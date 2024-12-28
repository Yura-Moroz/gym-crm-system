package com.yuramoroz.spring_crm_system.repository;

import com.yuramoroz.spring_crm_system.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TrainerDAO implements BaseDAO<Trainer> {
    private Map<Long, Trainer> trainerStorage;

    @Override
    public Trainer getById(Long id) {
        return trainerStorage.get(id);
    }

    @Override
    public List<Trainer> getAllItems() {return new ArrayList<>(trainerStorage.values());}

    @Override
    public void create(Trainer trainer) {
        trainerStorage.put(trainer.getId(), trainer);
    }

    @Override
    public void update(Trainer trainer) {
        trainerStorage.put(trainer.getId(), trainer);
    }

    @Override
    public void delete(Trainer trainer) {
        trainerStorage.remove(trainer.getId());
    }

    @Autowired
    public void setTrainerStorage(@Qualifier("trainerStorage") Map<Long, Trainer> trainerStorage){
        this.trainerStorage = trainerStorage;
    }
}
