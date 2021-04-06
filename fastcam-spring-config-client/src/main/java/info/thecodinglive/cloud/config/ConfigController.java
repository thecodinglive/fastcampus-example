package info.thecodinglive.cloud.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequiredArgsConstructor
public class ConfigController {
    private final ConfigProp configProp;

    @GetMapping("/v1/check/prop")
    public String findPropMessage() {
        return configProp.toString();
    }
}
