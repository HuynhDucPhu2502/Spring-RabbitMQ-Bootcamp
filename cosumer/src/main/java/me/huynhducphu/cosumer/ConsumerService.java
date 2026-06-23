package me.huynhducphu.cosumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.huynhducphu.cosumer.entity.Employee;
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

    ObjectMapper objectMapper;

    @RabbitListener(queues = "HelloWorld")
    public void printHelloWorld(String message) {
        System.out.println(message);
    }

    @RabbitListener(queues = "RealTime")
    public void printRealTime(String message) {
        System.out.println(message);
    }

    @RabbitListener(queues = "jsonQueue")
    public void printparsedJson(String message) throws Exception {

        var payload = objectMapper.readValue(message, Employee.class);

        System.out.println(payload);
    }

}
