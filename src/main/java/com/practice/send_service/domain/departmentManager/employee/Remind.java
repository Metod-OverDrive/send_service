package com.practice.send_service.domain.departmentManager.employee;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Remind {

    private String taskTitle;
    private String taskDescription;
    private Date expirationDate;
    private List<Employee> employees;

}
