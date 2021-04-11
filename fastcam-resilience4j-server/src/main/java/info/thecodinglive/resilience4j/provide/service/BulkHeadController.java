package info.thecodinglive.resilience4j.provide.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
public class BulkHeadController {
    private static final int DELAY = 100;
    private int count = 0;

    @GetMapping("/")
    public String okay() {
        return "I'm fine.";
    }

    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        Thread.sleep(DELAY);
        return "I'm fine, just slow";
    }

    @GetMapping("/error")
    public String error() {
        throw new InternalServerErrorException("I'm absolutely not fine!");
    }

    @GetMapping("/erratic")
    public String erratic() throws InterruptedException {
        log.info(Integer.toString(count++));

        if(ThreadLocalRandom.current().nextInt(0 , 5) == 0) {
            log.error("erratic");
            throw new InterruptedException("erratic occured");
        }
        log.info("sucess");
        return "ok";
    }
}
