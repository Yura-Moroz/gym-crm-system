package com.yuramoroz.spring_crm_system.service;

import com.yuramoroz.spring_crm_system.dao.TraineeDAO;
import com.yuramoroz.spring_crm_system.entity.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeService {
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
