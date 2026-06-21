package me.huynhducphu.cosumer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Admin 6/21/2026
 *
 **/
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ConsumerService {

    @RabbitListener(queues = "HelloWorld")
    public void printHelloWorld(String message) {
        System.out.println(message);
    }

    @RabbitListener(queues = "RealTime")
    public void printRealTime(String message) {
        System.out.println(message);
    }

}
