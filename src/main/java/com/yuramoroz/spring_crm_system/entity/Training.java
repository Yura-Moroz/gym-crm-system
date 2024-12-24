package com.yuramoroz.spring_crm_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Training {
    private Long id;
    private Long traineeId;
    private Long trainerId;
    private String trainingName;
    private TrainingTypeName trainingType;
    private LocalDate trainingDate;
    private Long trainingDuration;
}
