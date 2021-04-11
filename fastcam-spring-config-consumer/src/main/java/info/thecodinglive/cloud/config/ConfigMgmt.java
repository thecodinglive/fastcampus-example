package info.thecodinglive.cloud.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class ConfigMgmt {
    private final ObjectProvider<ConfigProp> configProps;

    public ConfigProp getConfigProperty() {
        return configProps.getIfAvailable();
    }
}
