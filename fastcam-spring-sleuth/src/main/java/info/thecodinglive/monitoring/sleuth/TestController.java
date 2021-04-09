package info.thecodinglive.monitoring.sleuth;

import brave.sampler.Sampler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class TestController {
    @GetMapping("/")
    public String helloSleuth() {
        log.info("Hello Sleuth");
        return "success";
    }

}
