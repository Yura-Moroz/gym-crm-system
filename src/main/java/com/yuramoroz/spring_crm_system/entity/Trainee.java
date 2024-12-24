package com.yuramoroz.spring_crm_system.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Trainee extends User{
    private Long id;
    private String address;
    private LocalDate dateOfBirth;

    public Trainee(Long userId, String firstName, String lastName, String userName, String password, Boolean isActive, String address, LocalDate dateOfBirth) {
        super(firstName, lastName, userName, password, isActive);
        this.id = userId;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }
}
