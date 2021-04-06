package info.thecodinglive.feignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class FeignApp {
    public static void main(String ar[]) {
        SpringApplication.run(FeignApp.class, ar);
    }
}
