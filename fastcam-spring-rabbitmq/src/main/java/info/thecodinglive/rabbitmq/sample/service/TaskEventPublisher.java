package info.thecodinglive.rabbitmq.sample.service;

import info.thecodinglive.rabbitmq.config.FastcamRabbitQueue;
import info.thecodinglive.rabbitmq.sender.RabbitMessageSender;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class TaskEventPublisher extends RabbitMessageSender {
    public TaskEventPublisher(RabbitTemplate rabbitTemplate) {
        super(rabbitTemplate);
    }

    @Override
    public void send(FastcamRabbitQueue queueName, Object data) {
        super.send(queueName, data);
    }
}
