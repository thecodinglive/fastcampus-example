package info.thecodinglive.kafka.eventService;

import java.util.Map;
import java.util.UUID;

public class MyEvent {

    private String eventId;
    private Map<String, Object> myData;


    public MyEvent(Map<String, Object> myData) {
        this.eventId = UUID.randomUUID().toString();
        this.myData = myData;
    }

    public String getEventId() {
        return eventId;
    }

    public Map<String, Object> getMyData() {
        return myData;
    }
}
