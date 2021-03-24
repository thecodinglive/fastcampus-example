package info.thecodinglive.rabbitmq.sender;

import info.thecodinglive.rabbitmq.config.FastcamRabbitQueue;
import info.thecodinglive.rabbitmq.sample.model.MyTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RabbitMQSenderTest {
    @Autowired
    private RabbitMessagePublisher publisher;

    @Test
    public void sendMsg() {
        String msg = "you guys do something!!!";
        publisher.publish(FastcamRabbitQueue.SAMPLE_TASK.getQueueName(), new MyTask(msg));
    }
}
