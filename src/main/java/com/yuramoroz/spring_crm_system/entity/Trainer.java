package com.yuramoroz.spring_crm_system.entity;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Trainer extends User{
    private Long id;
    private String specialization;

    public Trainer() {}

    public Trainer(Long id, String firstName, String lastName, Boolean isActive, String specialization) {
        super(firstName, lastName, isActive);
        this.id = id;
        this.specialization = specialization;
    }
}
