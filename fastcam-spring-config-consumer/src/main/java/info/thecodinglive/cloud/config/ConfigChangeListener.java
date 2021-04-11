package info.thecodinglive.cloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConfigChangeListener implements ApplicationListener<EnvironmentChangeEvent> {
    @Autowired ConfigProp configProp;

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent event) {
        //if(event.getKeys().contains("username"))
        log.info("event key: {}", event.getKeys().toString());
        //configProp.ref
    }
}
