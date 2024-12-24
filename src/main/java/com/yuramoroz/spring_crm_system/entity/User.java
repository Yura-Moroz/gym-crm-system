package com.yuramoroz.spring_crm_system.entity;

import lombok.*;

@Data
@AllArgsConstructor
public abstract class User {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Boolean isActive;

}
