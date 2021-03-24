package info.thecodinglive.rabbitmq;

import info.thecodinglive.rabbitmq.sample.model.MyTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RabbitMQApp {
    public static void main(String ar[]) {
        SpringApplication.run(RabbitMQApp.class, ar);
    }
}
