package com.yuramoroz.spring_crm_system.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuramoroz.spring_crm_system.config.StorageConfig;
import com.yuramoroz.spring_crm_system.entity.Trainee;
import com.yuramoroz.spring_crm_system.entity.Trainer;
import com.yuramoroz.spring_crm_system.entity.Training;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Component
public class StorageInitializer implements BeanPostProcessor {

    private final ObjectMapper mapper = new ObjectMapper();

    private final Map<Long, Trainee> traineeMap;
    private final Map<Long, Trainer> trainerMap;
    private final Map<String, Training> trainingMap;
    @Value("${storage.init.file}")
    private String filePath;

    public StorageInitializer(@Qualifier("traineeStorage") Map<Long, Trainee> traineeMap,
                              @Qualifier("trainerStorage") Map<Long, Trainer> trainerMap,
                              @Qualifier("trainingStorage") Map<String, Training> trainingMap) {
        this.traineeMap = traineeMap;
        this.trainerMap = trainerMap;
        this.trainingMap = trainingMap;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof StorageConfig){
            initializeStorage();
        }
        return bean;
    }

    public void initializeStorage(){
        try (InputStream input = Files.newInputStream(Paths.get(filePath))){

            Map<String, List<Map<String, Object>>> data = mapper.readValue(input, Map.class);

            data.get("trainers").forEach(entry -> {
                Trainer trainer = mapper.convertValue(entry, Trainer.class);
                trainerMap.put(trainer.getId(), trainer);
            });

            data.get("trainees").forEach(entry -> {
                Trainee trainee = mapper.convertValue(entry, Trainee.class);
                traineeMap.put(trainee.getId(), trainee);
            });

            data.get("trainings").forEach(entry -> {
                Training training = mapper.convertValue(entry, Training.class);
                trainingMap.put(training.getTrainingName(), training);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
