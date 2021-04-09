package info.thecodinglive.cloud.app;

import info.thecodinglive.cloud.config.ConfigProp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Slf4j
@EnableConfigurationProperties(ConfigProp.class)
@SpringBootApplication
public class ConfigConsumerApp implements CommandLineRunner {
    private final ConfigProp configProp;

    @Override
    public void run(String... args) throws Exception {
      log.info("load configserver property : {}", configProp.toString());
    }

    public ConfigConsumerApp(ConfigProp configProp) {
        this.configProp = configProp;
    }

    public static void main(String ar[]) {
        SpringApplication.run(ConfigConsumerApp.class, ar);
    }
}
