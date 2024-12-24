package com.yuramoroz.spring_crm_system.entity;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Trainer extends User{
    private Long id;
    private String specialization;

    public Trainer(String firstName, String lastName, String userName, String password, Boolean isActive, Long id, String specialization) {
        super(firstName, lastName, userName, password, isActive);
        this.id = id;
        this.specialization = specialization;
    }
}
