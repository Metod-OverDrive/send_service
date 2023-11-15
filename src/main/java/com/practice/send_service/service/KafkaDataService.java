package com.practice.send_service.service;

import com.practice.send_service.domain.departmentManager.employee.Remind;

public interface KafkaDataService {

    void handle(Remind remind);
}
