package info.thecodinglive.feignclient.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "info.thecodinglive.feignclient.mapService")
public class MapServiceFeignClientConfig {
}
