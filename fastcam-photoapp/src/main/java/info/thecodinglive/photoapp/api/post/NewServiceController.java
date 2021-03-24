package info.thecodinglive.photoapp.api.post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewServiceController {
    @GetMapping("/v1.0/newservice")
    public String releaseNewService() {
        return "open new service";
    }
}
