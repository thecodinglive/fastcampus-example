package info.thecodinglive.monitoring;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSleuth {
    public static void main(String ar[]) {
        SpringApplication.run(SpringSleuth.class, ar);
    }
}
