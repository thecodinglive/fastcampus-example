package info.thecodinglive.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApp {
    public static void main(String ar[]) {
        SpringApplication.run(EurekaServerApp.class);
    }
}
