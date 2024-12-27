package com.yuramoroz.spring_crm_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate trainingDate;
    private Long trainingDuration;

    public Training() {
    }
}
