package info.thecodinglive.rabbitmq.receiver;

import info.thecodinglive.rabbitmq.sample.model.MyTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQReceiver {
    @RabbitListener(id = "photo.sample", queues = "photo.sample")
    public void handle(MyTask task) {
        LOG.info("mydata handle:: {}", task.toString());
    }
}
