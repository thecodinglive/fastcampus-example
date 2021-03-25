package info.thecodinglive.kafka.eventService;

import info.thecodinglive.kafka.sender.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class MyEventService {
    @Autowired
    private KafkaProducer kafkaProducer;

    public void sendMsg() {
        Map<String, Object> data = new HashMap<>();
        data.put("width", 1020);
        data.put("height", 7090);

        kafkaProducer.send(KafkaProducer.TOPIC_NAME, new MyEvent(data));
    }

}
