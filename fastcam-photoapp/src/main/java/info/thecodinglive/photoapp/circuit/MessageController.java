package info.thecodinglive.photoapp.circuit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private static final int SECOND = 1000;

    @GetMapping("/")
    public String okay() {
        return "I'm fine.";
    }

    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        Thread.sleep(SECOND);
        return "I'm fine, just slow";
    }

    @GetMapping("/error")
    public String error() {
        throw new InternalServerErrorException("I'm definitely not fine!");
    }


}
