package info.thecodinglive.kafka;

import info.thecodinglive.kafka.sender.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SenderTest {

    @Autowired
    private KafkaProducer producer;

    @Test
    void sendMsg() {
        //send String
        producer.send("thecodinglive", "hello kafka");
    }
}
