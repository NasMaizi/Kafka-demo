package com.example.kafka.consumer;

import com.example.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
   // @KafkaListener(topics = "nasro",groupId = "myGroup")
    public void consumeMsg(String msg){

        log.info(String.format("Consuming the message from nasro topic:: %s", msg));
    }
    @KafkaListener(topics = "nasro", groupId="myGroup")
    public void consumeJsonMsg(Student student){
        log.info(String.format("Consuming the message from nasro topic:: %s", student.toString()));
    }
}
