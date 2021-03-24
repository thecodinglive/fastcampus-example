package info.thecodinglive.rabbitmq.sender;

import info.thecodinglive.rabbitmq.config.FastcamRabbitQueue;
import info.thecodinglive.rabbitmq.sample.model.MyTask;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@RequiredArgsConstructor
public abstract class RabbitMessageSender {
    private final RabbitTemplate rabbitTemplate;

    public void send(FastcamRabbitQueue queueName, Object data) {
        Assert.isNull(data, "message can't be null");
        Message msg = rabbitTemplate.getMessageConverter().toMessage(data, null);
        rabbitTemplate.send(String.valueOf(queueName), msg);
    }
}
