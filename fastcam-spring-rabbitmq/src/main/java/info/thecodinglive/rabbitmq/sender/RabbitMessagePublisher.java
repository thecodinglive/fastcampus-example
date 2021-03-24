package info.thecodinglive.rabbitmq.sender;

import info.thecodinglive.rabbitmq.sample.model.MyTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class RabbitMessagePublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publish(String routingKey, MyTask myTask) {
        try {
            rabbitTemplate.convertAndSend("thecodinglive", "photo.sample", myTask);
        } catch (Exception e) {
            LOG.error("error", e);
        }
    }
}
