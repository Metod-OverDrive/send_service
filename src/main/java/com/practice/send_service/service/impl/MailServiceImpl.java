package com.practice.send_service.service.impl;

import com.practice.send_service.domain.MailType;
import com.practice.send_service.domain.departmentManager.employee.Employee;
import com.practice.send_service.domain.departmentManager.employee.Remind;
import com.practice.send_service.service.MailService;
import freemarker.template.Configuration;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final Configuration configuration;
    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(Remind remind, MailType type) {
        switch (type) {
            case TASK_REMINDER ->  sendRemainderEmail(remind);
        }
    }

    @SneakyThrows
    private void sendRemainderEmail(Remind remind) {
        List<Employee> employees = remind.getEmployees();
        for(Employee employee: employees) {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
            helper.setSubject("You have task to complete in 1 day");
            helper.setTo(employee.getUsername());
            String emailContent = getRemindEmailContent(remind, employee);
            helper.setText(emailContent, true);
            mailSender.send(mimeMessage);
        }
    }

    @SneakyThrows
    private String getRemindEmailContent(Remind remind, Employee employee) {
        StringWriter writer = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("name", employee.getUsername());
        model.put("title", remind.getTaskTitle());
        model.put("description", remind.getTaskDescription());
        model.put("date", remind.getExpirationDate());
        configuration.getTemplate("reminder.ftlh")
                .process(model, writer);
        return writer.getBuffer().toString();
    }


}
