package info.thecodinglive.photoapp.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@Setter
@Getter
public class PhotoAppProperties {
    @Value("${photoapp.file.defaultPath}")
    private String defaultPath;

    @PostConstruct
    private void init() {
        LOG.info("path:: {}",this.defaultPath);
    }
}
