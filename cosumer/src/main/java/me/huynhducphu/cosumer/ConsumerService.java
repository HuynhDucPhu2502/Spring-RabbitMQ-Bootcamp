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

    @RabbitListener(queues = "queue.a")
    public void testFanoutQueueA(String message) throws Exception {
        System.out.println(message);
    }

    @RabbitListener(queues = "queue.b")
    public void testFanoutQueueB(String message) throws Exception {
        System.out.println(message);
    }

    @RabbitListener(queues = "queue.c")
    public void testFanoutQueueC(String message) throws Exception {
        System.out.println(message);
    }

    @RabbitListener(queues = "queue.1")
    public void testDirectQueue1(String message) throws Exception {
        System.out.println(message);
    }

    @RabbitListener(queues = "queue.2")
    public void testDirectQueue2(String message) throws Exception {
        System.out.println(message);
    }

    @RabbitListener(queues = "queue.3")
    public void testDirectQueue3(String message) throws Exception {
        System.out.println(message);
    }

}
