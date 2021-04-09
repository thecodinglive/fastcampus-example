package info.thecodinglive.feignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class FeignApp {
    public static void main(String ar[]) {
        SpringApplication.run(FeignApp.class, ar);
    }
}
