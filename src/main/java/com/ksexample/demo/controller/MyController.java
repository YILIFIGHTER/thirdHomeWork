package com.ksexample.demo.controller;

import com.ksexample.demo.publisher.KafkaPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private KafkaPublisher kafkaPublisher;

    // 3、使用apollo配置
    @Value("${test:默认值}")
    private String test;

    //5、测试应用程序
    // curl -X POST -H "Content-Type: text/plain" -d "Hello, Kafka!" http://localhost:8080/publish
    @PostMapping("/publish")
    public void publishMessage(@RequestBody String message) {
        kafkaPublisher.publish(message);
    }

    //测试配置值
    @GetMapping("/test")
    public String test() {
        return "test的值为:" + test;
    }
}
