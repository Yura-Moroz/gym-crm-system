package com.yuramoroz.spring_crm_system;

import com.yuramoroz.spring_crm_system.dao.TraineeDAO;
import com.yuramoroz.spring_crm_system.entity.Trainee;
import com.yuramoroz.spring_crm_system.service.TraineeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;

public class TraineeServiceTest {
    @Mock
    private TraineeDAO traineeDAO;

    @InjectMocks
    private TraineeService traineeService;

    private Trainee trainee;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        trainee = new Trainee(37L, "Peter", "Tarantino", "taranPet@000", "ytrewq",
                true, "Lviv", LocalDate.of(1999, 8, 29));
    }

    @Test
    public void createTraineeTest(){
        traineeService.createTrainee(trainee);
        verify(traineeDAO, times(1)).create(trainee);
    }

    @Test
    public void updateTraineeTest(){
        traineeService.updateTrainee(trainee);
        verify(traineeDAO, times(1)).update(trainee);
    }

    @Test
    public void deleteTraineeTest(){
        traineeService.deleteTrainee(trainee);
        verify(traineeDAO, times(1)).delete(trainee);
    }

    @Test
    public void getTraineeByIdTest(){
        when(traineeDAO.getById(trainee.getId())).thenReturn(trainee);
        Trainee result = traineeService.getTraineeById(trainee.getId());
        verify(traineeDAO, times(1)).getById(trainee.getId());
        Assertions.assertEquals(trainee, result);
    }

    @Test
    public void getAllTraineesTest(){
        List<Trainee> trainees = List.of(trainee);
        when(traineeDAO.getAllItems()).thenReturn(trainees);

        List<Trainee> resultList = traineeService.getAllTrainees();
        verify(traineeDAO, times(1)).getAllItems();
        Assertions.assertEquals(resultList, trainees);
    }
}
