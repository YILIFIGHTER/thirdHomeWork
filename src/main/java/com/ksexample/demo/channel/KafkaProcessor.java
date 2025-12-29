package com.ksexample.demo.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

// 3、创建消息处理器
public interface KafkaProcessor {
    String INPUT = "input"; // 输入通道名称，对应配置中的bindings.input.destination

    String OUTPUT = "output"; // 输出通道名称，对应配置中的bindings.output.destination

    @Input(INPUT) // 输入通道注解，用于接收消息
    SubscribableChannel input();

    @Output(OUTPUT) // 输出通道注解，用于发送消息
    MessageChannel output();
}

