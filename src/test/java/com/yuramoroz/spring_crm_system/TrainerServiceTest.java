package com.yuramoroz.spring_crm_system;

import com.yuramoroz.spring_crm_system.repository.TrainerDAO;
import com.yuramoroz.spring_crm_system.entity.Trainer;
import com.yuramoroz.spring_crm_system.service.TrainerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class TrainerServiceTest {
    @Mock
    private TrainerDAO trainerDAO;

    @InjectMocks
    private TrainerService trainerService;

    private Trainer trainer;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        trainer = new Trainer(3L, "Jason", "Statham",true, "Martial Arts");
    }

    @Test
    public void createTrainerTest(){
        trainerService.createTrainer(trainer);
        verify(trainerDAO, times(1)).create(trainer);
    }

    @Test
    public void updateTrainerTest(){
        trainerService.updateTrainer(trainer);
        verify(trainerDAO, times(1)).update(trainer);
    }

    @Test
    public void deleteTrainerTest(){
        trainerService.deleteTrainer(trainer);
        verify(trainerDAO, times(1)).delete(trainer);
    }

    @Test
    public void getTrainerByIdTest(){
        when(trainerDAO.getById(trainer.getId())).thenReturn(trainer);
        Trainer result = trainerService.getTrainerById(trainer.getId());
        verify(trainerDAO, times(1)).getById(trainer.getId());
        Assertions.assertEquals(trainer, result);
    }

    @Test
    public void getAllTrainersTest(){
        List<Trainer> trainers = List.of(trainer);
        when(trainerDAO.getAllItems()).thenReturn(trainers);

        List<Trainer> resultList = trainerService.getAllTrainers();
        verify(trainerDAO, times(1)).getAllItems();
        Assertions.assertEquals(resultList, trainers);
    }
}
