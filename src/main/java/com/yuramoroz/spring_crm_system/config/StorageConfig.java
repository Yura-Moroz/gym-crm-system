package com.yuramoroz.spring_crm_system.config;

import com.yuramoroz.spring_crm_system.entity.Trainee;
import com.yuramoroz.spring_crm_system.entity.Trainer;
import com.yuramoroz.spring_crm_system.entity.Training;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class StorageConfig {

    @Bean
    public Map<Long, Trainee> traineeStorage(){
        return new HashMap<>();
    }

    @Bean
    public Map<Long, Trainer> trainerStorage(){
        return new HashMap<>();
    }

    @Bean
    public Map<String, Training> trainingStorage(){
        return new HashMap<>();
    }
}
