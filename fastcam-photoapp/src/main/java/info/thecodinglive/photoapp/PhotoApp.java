package info.thecodinglive.photoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PhotoApp {
    public static void main(String ar[]) {
        SpringApplication.run(PhotoApp.class, ar);
    }
}
