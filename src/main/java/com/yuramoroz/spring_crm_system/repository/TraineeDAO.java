package com.yuramoroz.spring_crm_system.repository;

import com.yuramoroz.spring_crm_system.entity.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TraineeDAO implements BaseDAO<Trainee> {
    private Map<Long, Trainee> traineeStorage;

    @Override
    public Trainee getById(long id) {
        return traineeStorage.get(id);
    }

    @Override
    public List<Trainee> getAllItems() {return new ArrayList<>(traineeStorage.values());}

    @Override
    public Trainee create(Trainee trainee) {
        traineeStorage.put(trainee.getId(), trainee);
        return trainee;
    }

    @Override
    public Trainee update(long id) {
        Trainee trainee = traineeStorage.get(id);
        traineeStorage.put(id, trainee);
        return trainee;
    }

    @Override
    public void delete(Trainee trainee) {
        traineeStorage.remove(trainee.getId());
    }

    @Autowired
    public void setTraineeStorage(@Qualifier("traineeStorage") Map<Long, Trainee> traineeStorage){
        this.traineeStorage = traineeStorage;
    }
}
