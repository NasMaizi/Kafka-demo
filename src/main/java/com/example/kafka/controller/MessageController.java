package com.example.kafka.controller;

import com.example.kafka.payload.Student;
import com.example.kafka.producer.KafkaJsonProducer;
import com.example.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaJsonProducer kafkaJsonProducer;
    private final KafkaProducer kafkaProducer;


    @PostMapping
    public ResponseEntity<String> sendMessage(
            @RequestBody String message
    ){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully");
    }
    @PostMapping("/json")
    public ResponseEntity<String> sendMessage(
            @RequestBody Student message
    ){
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully as JSON");
    }
}
