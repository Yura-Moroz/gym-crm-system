package com.yuramoroz.spring_crm_system.service;

import com.yuramoroz.spring_crm_system.entity.TrainingTypeName;
import com.yuramoroz.spring_crm_system.repository.TrainingDAO;
import com.yuramoroz.spring_crm_system.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainingService {

    private static long trainingIDs = 0;

    @Autowired
    private TrainingDAO trainingDAO;

    public Training createTraining(Training training){
        trainingDAO.create(training);
        return training;
    }

    public Training createTraining(long traineeId, long trainerId, String trainingName,
                                   TrainingTypeName trainingType, LocalDateTime trainingDate, Duration trainingDuration){
        Training training = new Training();
        training.setTraineeId(traineeId);
        training.setTrainerId(trainerId);
        training.setTrainingName(trainingName);
        training.setTrainingType(trainingType);
        training.setTrainingDate(trainingDate);
        training.setTrainingDuration(trainingDuration);
        training.setId(++trainingIDs);
        return createTraining(training);
    }

    public Training getTrainingById(Long id){
        return trainingDAO.getById(id);
    }

    public List<Training> getAllTrainings(){
        return trainingDAO.getAllItems();
    }
}
