package info.thecodinglive.feignclient.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ConfigController {
    @Autowired
    private  ConfigProp configProp;


    @GetMapping("/v1/check/prop")
    public String findPropMessage() {
        log.info("config:: {}", configProp.toString());
        return "ok";
    }
}
