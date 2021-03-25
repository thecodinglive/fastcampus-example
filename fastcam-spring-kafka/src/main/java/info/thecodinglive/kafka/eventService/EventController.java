package info.thecodinglive.kafka.eventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @Autowired
    MyEventService myEventService;

    @GetMapping("/event")
    public String getEvent() {
        myEventService.sendMsg();
        return "OK";
    }
}
