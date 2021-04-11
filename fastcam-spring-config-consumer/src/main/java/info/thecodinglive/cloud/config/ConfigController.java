package info.thecodinglive.cloud.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;


@RequiredArgsConstructor
@RestController
public class ConfigController {
    private final ConfigMgmt configMgmt;

    @GetMapping("/v1/check/prop")
    public String findPropMessage() {
        return configMgmt.getConfigProperty().toString();
    }
}
