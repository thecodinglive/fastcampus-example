package info.thecodinglive.kafka.sender;

import info.thecodinglive.utils.jackson.FastcamJacksonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    public static final String TOPIC_NAME = "thecodinglive";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, Object data) {
        try {
            kafkaTemplate.send(topic, FastcamJacksonConverter.toJson(data));
        } catch (Exception e) {
            System.err.println("error" +  e.getMessage());
        }
    }
}
