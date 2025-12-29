package com.ksexample.demo.publisher;

import com.ksexample.demo.channel.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublisher {
    @Autowired
    private KafkaProcessor kafkaProcessor;

    // 4、创建消息发布器
    public void publish(String message) {
        kafkaProcessor.output().send(MessageBuilder.withPayload(message).build());
    }
}
