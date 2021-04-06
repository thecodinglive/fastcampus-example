package info.thecodinglive.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class AdminServerApp {
    public static void main(String ar[]) {
        SpringApplication.run(AdminServerApp.class, ar);
    }
}
