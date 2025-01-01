package com.yuramoroz.spring_crm_system;

import com.yuramoroz.spring_crm_system.repository.TrainingDAO;
import com.yuramoroz.spring_crm_system.entity.Training;
import com.yuramoroz.spring_crm_system.entity.TrainingTypeName;
import com.yuramoroz.spring_crm_system.service.TrainingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class TrainingServiceTest {
    @Mock
    private TrainingDAO trainingDAO;

    @InjectMocks
    private TrainingService trainingService;

    private Training training;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        training = new Training(15L, 44L, 3L, "Chest",
                TrainingTypeName.BENCH_TRAINING, LocalDateTime.of(2025, Month.AUGUST, 27, 12, 0, 0), Duration.ofMinutes(90));
    }

    @Test
    public void createTrainingTest(){
        trainingService.createTraining(training);
        verify(trainingDAO, times(1)).create(training);
    }

    @Test
    public void getTrainingByIdTest(){
        when(trainingDAO.getById(training.getId())).thenReturn(training);
        Training result = trainingService.getTrainingById(training.getId());
        verify(trainingDAO, times(1)).getById(training.getId());
        Assertions.assertEquals(training, result);
    }

    @Test
    public void getAllTrainingsTest(){
        List<Training> trainings = List.of(training);
        when(trainingDAO.getAllItems()).thenReturn(trainings);

        List<Training> resultList = trainingService.getAllTrainings();
        verify(trainingDAO, times(1)).getAllItems();
        Assertions.assertEquals(resultList, trainings);
    }
}
