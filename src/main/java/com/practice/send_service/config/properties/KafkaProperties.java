package com.practice.send_service.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.kafka.consumer")
@Getter
@Setter
public class KafkaProperties {

    private String groupId;
    private String keyDeserializer;
    private String valueDeserializer;
    private String trustedPackages;
}
