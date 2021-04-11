package info.thecodinglive.cloud.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/v1.1/test")
    public String hello() {
        return "hello";
    }
}
