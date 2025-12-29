package com.ksexample.demo.handler;

import com.ksexample.demo.channel.KafkaProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;


@EnableBinding
public class StreamHandler {

    @StreamListener(KafkaProcessor.INPUT)
    public void handle(Message<String> message) {
        System.out.println("Received message: " + message.getPayload());
    }
}
