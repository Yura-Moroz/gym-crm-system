package com.yuramoroz.spring_crm_system.service;

import com.yuramoroz.spring_crm_system.repository.TrainerDAO;
import com.yuramoroz.spring_crm_system.entity.Trainer;
import com.yuramoroz.spring_crm_system.utils.ProfileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService{

    private static long trainerIDs = 0;

    @Autowired
    private TrainerDAO trainerDAO;

    public Trainer createTrainer(Trainer trainer){
        trainerDAO.create(trainer);
        return trainer;
    }

    public Trainer createTrainer(String firstName, String lastName, boolean isActive, String specialization){
        Trainer trainer = new Trainer();
        trainer.setFirstName(firstName);
        trainer.setLastName(lastName);
        trainer.setIsActive(isActive);
        trainer.setSpecialization(specialization);
        trainer.setPassword(ProfileHandler.generatePassword());
        trainer.setUserName(ProfileHandler.generateUsername(trainer));
        trainer.setId(++trainerIDs);
        return createTrainer(trainer);
    }

    public Trainer updateTrainer(long id){
        return trainerDAO.update(id);
    }

    public Trainer getTrainerById(long id){
        return trainerDAO.getById(id);
    }

    public List<Trainer> getAllTrainers(){
        return trainerDAO.getAllItems();
    }
}
