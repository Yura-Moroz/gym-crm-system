package com.yuramoroz.spring_crm_system.service;

import com.yuramoroz.spring_crm_system.repository.TraineeDAO;
import com.yuramoroz.spring_crm_system.entity.Trainee;
import com.yuramoroz.spring_crm_system.utils.ProfileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TraineeService {

    private static long traineeIDs = 0L;

    @Autowired
    private TraineeDAO traineeDAO;

    public Trainee createTrainee(Trainee trainee) {
        traineeDAO.create(trainee);
        return trainee;
    }

    public Trainee createTrainee(String firstName, String lastName, Boolean isActive, String address, LocalDate dateOfBirth) {
        Trainee trainee = new Trainee();
        trainee.setFirstName(firstName);
        trainee.setLastName(lastName);
        trainee.setIsActive(isActive);
        trainee.setAddress(address);
        trainee.setDateOfBirth(dateOfBirth);
        trainee.setPassword(ProfileHandler.generatePassword());
        trainee.setUserName(ProfileHandler.generateUsername(trainee));
        trainee.setId(++traineeIDs);
        return createTrainee(trainee);
    }

    public Trainee updateTrainee(long id) {
        return traineeDAO.update(id);
    }

    public void deleteTrainee(Trainee trainee) {
        traineeDAO.delete(trainee);
    }

    public Trainee getTraineeById(long id) {
        return traineeDAO.getById(id);
    }

    public List<Trainee> getAllTrainees() {
        return traineeDAO.getAllItems();
    }
}
