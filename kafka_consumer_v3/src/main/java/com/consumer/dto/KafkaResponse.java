package com.consumer.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class KafkaResponse {

    @JsonProperty("message")
    private String message;

    private LocalDateTime time;

    public String printable(){
        try{
            return new ObjectMapper().writeValueAsString(this);
        }catch(JsonProcessingException e){
            return "Unserializable data";
        }
    }
}
