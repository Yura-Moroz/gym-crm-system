package com.yuramoroz.spring_crm_system.service;

import com.yuramoroz.spring_crm_system.dao.TrainerDAO;
import com.yuramoroz.spring_crm_system.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {
    @Autowired
    private TrainerDAO trainerDAO;

    public void createTrainer(Trainer trainer){
        trainerDAO.create(trainer);
    }

    public void updateTrainer(Trainer trainer){
        trainerDAO.update(trainer);
    }

    public void deleteTrainer(Trainer trainer){
        trainerDAO.delete(trainer);
    }

    public Trainer getTrainerById(Long id){
        return trainerDAO.getById(id);
    }

    public List<Trainer> getAllTrainers(){
        return trainerDAO.getAllItems();
    }
}
