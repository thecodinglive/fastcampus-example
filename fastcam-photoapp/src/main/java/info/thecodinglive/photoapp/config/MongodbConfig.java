package info.thecodinglive.photoapp.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
@Getter
public class MongodbConfig {
    @Value("${mongodbserver.url}")
    private String mongoUrl;
}
