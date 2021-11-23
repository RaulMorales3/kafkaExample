package com.consumer.service;

import com.consumer.dto.KafkaResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaConsumerPorto {

    @KafkaListener(topics = "${message.topic.name1}", groupId = "${message.group.name1}"
            ,containerFactory = "KafkaListenerFactory")
    public void listenOnboardingMessages(@Payload KafkaResponse message) {

        System.out.println(message.printable());
    }
}