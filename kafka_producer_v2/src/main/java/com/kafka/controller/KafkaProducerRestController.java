package com.kafka.controller;

import com.kafka.dto.KafkaRequest;
import com.kafka.producer.KafkaProducerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
public class KafkaProducerRestController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @RequestMapping(value = "/produceMessage", method = RequestMethod.POST)
    public String produceMessage(@Valid @RequestBody KafkaRequest MsgResponse) {
        kafkaProducerService.produceMessage(MsgResponse);
        return null;
    }
}