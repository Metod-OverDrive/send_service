package com.practice.send_service.domain.departmentManager.employee;

import lombok.Data;

import java.util.Set;

@Data
public class Employee {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String phoneNumber;
    private String password;
    private Float salary;
    private Boolean isActive;
    private Set<Role> roles;

}