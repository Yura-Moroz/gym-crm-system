package com.yuramoroz.spring_crm_system.service;

import com.yuramoroz.spring_crm_system.repository.TrainingDAO;
import com.yuramoroz.spring_crm_system.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {
    @Autowired
    private TrainingDAO trainingDAO;

    public void createTraining(Training training){
        trainingDAO.create(training);
    }

    public void updateTraining(Training training){
        trainingDAO.update(training);
    }

    public void deleteTraining(Training training){
        trainingDAO.delete(training);
    }

    public Training getTrainingById(Long id){
        return trainingDAO.getById(id);
    }

    public List<Training> getAllTrainings(){
        return trainingDAO.getAllItems();
    }
}
