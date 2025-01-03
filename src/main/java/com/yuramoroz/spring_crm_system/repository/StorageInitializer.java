package com.yuramoroz.spring_crm_system.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuramoroz.spring_crm_system.config.AppConfig;
import com.yuramoroz.spring_crm_system.entity.Trainee;
import com.yuramoroz.spring_crm_system.entity.Trainer;
import com.yuramoroz.spring_crm_system.entity.Training;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Component
public class StorageInitializer implements BeanPostProcessor {

    private final ObjectMapper mapper;

    private final Map<Long, Trainee> traineeMap;
    private final Map<Long, Trainer> trainerMap;
    private final Map<Long, Training> trainingMap;
    @Value("${storage.init.file}")
    private String filePath;

    public StorageInitializer(@Qualifier("traineeStorage") Map<Long, Trainee> traineeMap,
                              @Qualifier("trainerStorage") Map<Long, Trainer> trainerMap,
                              @Qualifier("trainingStorage") Map<Long, Training> trainingMap,
                              ObjectMapper mapper) {
        this.traineeMap = traineeMap;
        this.trainerMap = trainerMap;
        this.trainingMap = trainingMap;
        this.mapper = mapper;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof AppConfig){
            initializeStorage();
        }
        return bean;
    }

    public void initializeStorage(){

//        if(filePath == null || filePath.isBlank()){
//            throw new IllegalArgumentException("No proper data for filePath");
//        }

        try (InputStream input = new FileInputStream("src/main/resources/initial-data.json")){

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
                trainingMap.put(training.getId(), training);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}