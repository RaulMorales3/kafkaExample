package com.kafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConf {

    @Value(value = "${message.topic.name1}")
    private String Topic;

    @Bean
    public NewTopic testTopic(){
        return TopicBuilder.name(Topic)
                .partitions(3)
                .replicas(1)
                .build();
    }
}
