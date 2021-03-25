package info.thecodinglive.kafka.receiver;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static info.thecodinglive.kafka.sender.KafkaProducer.TOPIC_NAME;

@Component
public class KafkaReceiver {
    @KafkaListener(topics = TOPIC_NAME, autoStartup = "true")
    public void eventHandler(Object event) {
        System.out.println("get data: "+ event);
    }

}
