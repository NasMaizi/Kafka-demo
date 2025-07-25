package com.example.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String msg) {
        log.info(String.format("Sending message to nasro Topic:: %s", msg));
        kafkaTemplate.send("nasro", msg);
    }
}
