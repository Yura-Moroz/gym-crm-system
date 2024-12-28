package com.yuramoroz.spring_crm_system.service;

import com.yuramoroz.spring_crm_system.repository.TraineeDAO;
import com.yuramoroz.spring_crm_system.entity.Trainee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeService {
    private static final Logger log = LogManager.getLogger(TraineeService.class);
    @Autowired
    private TraineeDAO traineeDAO;

    public void createTrainee(Trainee trainee){

        traineeDAO.create(trainee);
    }

    public void updateTrainee(Trainee trainee){
        traineeDAO.update(trainee);
    }

    public void deleteTrainee(Trainee trainee){
        traineeDAO.delete(trainee);
    }

    public Trainee getTraineeById(Long id){
        return traineeDAO.getById(id);
    }

    public List<Trainee> getAllTrainees(){
        return traineeDAO.getAllItems();
    }
}
