package me.huynhducphu.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import me.huynhducphu.producer.entity.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * Admin 6/21/2026
 *
 **/
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProducerService {

    RabbitTemplate rabbitTemplate;
    ObjectMapper objectMapper;

    @NonFinal
    static int count = 0;

    public void sendHelloWorldViaRabbitMQ() {
//        rabbitTemplate.convertAndSend("HelloWorld", "Hello World");
    }

    //    @Scheduled(fixedRate = 500)
    public void sendMessageRapidly() {
        rabbitTemplate.convertAndSend("RealTime", "Count: " + ++count);
    }

    public void sendEmployeeInformation() throws Exception {
        var payload = new Employee(
                1L + count,
                "Huỳnh Đức Phú " + count,
                LocalDate.of(2003, 02, 25)
        );
        ++count;

        var payloadJson = objectMapper.writeValueAsString(payload);

        rabbitTemplate.convertAndSend("jsonQueue", payloadJson);
    }


    public void sendMessageTestFanout() {
        rabbitTemplate.convertAndSend("fanOutExchange", "", "Hello World");
    }

    public void sendMessageTestDirect() {
        rabbitTemplate.convertAndSend("directExchange", "test.a", "test.a");
        rabbitTemplate.convertAndSend("directExchange", "test.b", "test.b");
        rabbitTemplate.convertAndSend("directExchange", "test.c", "test.c");
    }

}
