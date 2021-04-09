package info.thecodinglive.spgw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class SpGwApp {
    public static void main(String ar[]) {
        SpringApplication.run(SpGwApp.class);
    }
}
