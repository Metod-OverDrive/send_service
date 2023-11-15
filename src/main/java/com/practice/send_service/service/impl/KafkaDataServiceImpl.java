package com.practice.send_service.service.impl;

import com.practice.send_service.domain.departmentManager.employee.Remind;
import com.practice.send_service.service.KafkaDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaDataServiceImpl implements KafkaDataService {

    @Override
    public void handle(Remind remind) {
        log.info("Remind: {}", remind);
    }
}
