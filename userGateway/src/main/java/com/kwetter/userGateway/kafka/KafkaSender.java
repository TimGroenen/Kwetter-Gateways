package com.kwetter.userGateway.kafka;

import com.kwetter.userGateway.kafka.message.KafkaLoggingMessage;
import com.kwetter.userGateway.kafka.message.KafkaLoggingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {
    private final KafkaTemplate<String, String> kafkaTemplateString;
    private final KafkaTemplate<String, KafkaLoggingMessage> kafkaTemplateLogging;

    @Autowired
    KafkaSender(KafkaTemplate<String, String> kafkaTemplateString, KafkaTemplate<String, KafkaLoggingMessage> kafkaTemplateLogging) {
        this.kafkaTemplateString = kafkaTemplateString;
        this.kafkaTemplateLogging = kafkaTemplateLogging;
    }

    public void sendKafkaString(String message, String topicName) {
        kafkaTemplateString.send(topicName, message);
    }

    public void sendKafkaLogging(String content, KafkaLoggingType loggingType) {
        kafkaTemplateLogging.send("logging", new KafkaLoggingMessage("UserGateway", content, loggingType));
    }
}
