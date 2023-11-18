package com.practice.send_service.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice.send_service.config.DateDeserializer;
import com.practice.send_service.domain.departmentManager.employee.Remind;
import com.practice.send_service.service.KafkaDataReceiver;
import com.practice.send_service.service.KafkaDataService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class kafkaDataReceiverImpl implements KafkaDataReceiver{

    private final KafkaReceiver<String, Object> receiver;
    private final DateDeserializer dateDeserializer;
    private final KafkaDataService kafkaDataService;

    @PostConstruct
    private void  init() {
        fetch();
    }

    @Override
    public void fetch() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class,
                        dateDeserializer)
                .create();
        receiver.receive()
                .subscribe(r -> {
                    Remind remind = gson
                            .fromJson(r.value().toString(), Remind.class);
                    kafkaDataService.handle(remind);
                    r.receiverOffset().acknowledge();
                });
    }
}
