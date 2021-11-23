package com.kafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class KafkaRequest {

    @JsonProperty("message")
    private String message;

    private LocalDateTime time;

    public String printable(){
        try{
             ObjectMapper mapper = new ObjectMapper();
             mapper.findAndRegisterModules();
            return mapper.writeValueAsString(this);

        }catch(JsonProcessingException e){
            return "Can't serialize data" + e.getMessage();
        }
    }
}
