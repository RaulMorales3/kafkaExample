package com.kafka.producer;

import com.kafka.dto.KafkaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;


@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${message.topic.name1}")
    private String topicName;


    /**
     * Productor de mensaje al tema de ONBOARDING
     * @param topic
     * @param message
     */
    public void produceMessage(KafkaRequest MsgResponse) {
        MsgResponse.setTime(LocalDateTime.now());

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, MsgResponse.printable());
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Send message=["+ MsgResponse.printable() +"] with offset=["+ result.getRecordMetadata().offset() +"] and partition=["+result.getRecordMetadata().partition()+"]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.err.println("Unable to send message=["+ MsgResponse.toString() +"] due to : "+ex.getMessage());
            }
        });
    }
}
