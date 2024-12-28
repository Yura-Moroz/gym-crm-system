package com.yuramoroz.spring_crm_system;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.yuramoroz.spring_crm_system.repository.StorageInitializer;
import com.yuramoroz.spring_crm_system.entity.Trainee;
import com.yuramoroz.spring_crm_system.entity.Trainer;
import com.yuramoroz.spring_crm_system.entity.Training;
import com.yuramoroz.spring_crm_system.entity.TrainingTypeName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Map;

import static org.mockito.Mockito.*;

public class StorageInitializerTest {

    @Mock
    private Map<Long, Trainee> traineeStorage;

    @Mock
    private Map<Long, Trainer> trainerStorage;

    @Mock
    private Map<Long, Training> trainingStorage;

    @InjectMocks
    private StorageInitializer storageInitializer;

    private final ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        storageInitializer = new StorageInitializer(traineeStorage, trainerStorage, trainingStorage, mapper);
    }

    @Test
    void testInitializeStorage() throws Exception {
        // Updated JSON data
        String jsonData = """
                {
                  "trainers": [
                    {
                      "id": 1,
                      "firstName": "John",
                      "lastName": "Conor",
                      "userName": "John.Conor",
                      "password": "qwerty",
                      "isActive": true,
                      "specialization": "Fitness"
                    }
                  ],
                  "trainees": [
                    {
                      "id": 12,
                      "firstName": "Alex",
                      "lastName": "Bronco",
                      "userName": "Alex.Bronco",
                      "password": "azaza",
                      "isActive": true,
                      "address": "Kyiv",
                      "dateOfBirth": "26.07.2001"
                    }
                  ],
                  "trainings": [
                    {
                      "id": 15,
                      "traineeId": 12,
                      "trainerId": 1,
                      "trainingName": "Back",
                      "trainingType": "BACK_TRAINING",
                      "date": "05.01.2025",
                      "trainingDuration": 3600
                    }
                  ]
                }
                """;

        // Mock file input
        ByteArrayInputStream inputStream = new ByteArrayInputStream(jsonData.getBytes());

        // Spy on the ObjectMapper
        ObjectMapper mapperSpy = spy(mapper);
        doReturn(mapperSpy.readValue(inputStream, Map.class)).when(mapperSpy).readValue(any(InputStream.class), eq(Map.class));

        // Execute the initialization
        storageInitializer.initializeStorage();

        // Verify trainer data was added
        verify(trainerStorage, times(1)).put(1L, new Trainer(1L, "John", "Conor",true, "Fitness"));

        // Verify trainee data was added
        verify(traineeStorage, times(1)).put(12L, new Trainee(12L, "Alex", "Bronco",true, "Kyiv", LocalDate.of(2001, 7, 26)));

        // Verify training data was added
        verify(trainingStorage, times(1)).put(15L, new Training(15L, 12L, 1L, "Back", TrainingTypeName.BACK_TRAINING, LocalDate.of(2025, 1, 5), 3600L));
    }
}
