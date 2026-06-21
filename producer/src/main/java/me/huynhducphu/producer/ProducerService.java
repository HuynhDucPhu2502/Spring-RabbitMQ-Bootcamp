package me.huynhducphu.producer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Admin 6/21/2026
 *
 **/
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProducerService {

    RabbitTemplate rabbitTemplate;

    @NonFinal
    static int count = 0;

    public void sendHelloWorldViaRabbitMQ() {
//        rabbitTemplate.convertAndSend("HelloWorld", "Hello World");
    }

    //    @Scheduled(fixedRate = 500)
    public void sendMessageRapidly() {
        rabbitTemplate.convertAndSend("RealTime", "Count: " + ++count);
    }

}
