package com.yuramoroz.spring_crm_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Trainee extends User{
    private Long id;
    private String address;
    @JsonProperty("dateOfBirth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;

    public Trainee() {
    }

    public Trainee(Long userId, String firstName, String lastName, Boolean isActive, String address, LocalDate dateOfBirth) {
        super(firstName, lastName, isActive);
        this.id = userId;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }
}
