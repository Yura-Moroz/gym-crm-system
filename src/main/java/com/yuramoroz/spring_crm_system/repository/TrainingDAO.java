package com.yuramoroz.spring_crm_system.repository;

import com.yuramoroz.spring_crm_system.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TrainingDAO implements BaseDAO<Training> {
    private Map<Long, Training> trainingStorage;

    @Override
    public Training create(Training training) {
        trainingStorage.put(training.getId(), training);
        return training;
    }

    @Override
    public Training getById(long id) {
        return trainingStorage.get(id);
    }

    @Override
    public List<Training> getAllItems() {
        return new ArrayList<>(trainingStorage.values());
    }

    @Override
    public Training update(long id) {
        return null;
    }

    @Override
    public void delete(Training training) {}

    @Autowired
    public void setTrainingStorage(@Qualifier("trainingStorage") Map<Long, Training> trainingStorage){
        this.trainingStorage = trainingStorage;
    }
}
