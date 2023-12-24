package com.practice.send_service.service;

import com.practice.send_service.domain.MailType;
import com.practice.send_service.domain.departmentManager.employee.Remind;

public interface MailService {

    void sendEmail(Remind remind, MailType type);
}
