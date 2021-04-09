package info.thecodinglive.photoapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/clients")
    public String welcome() {
        List<ServiceInstance> instances = discoveryClient.getInstances("photoapp");
        ServiceInstance selectedInstance = instances.get(0);

        return "welcome to spring cloud:" + selectedInstance.getInstanceId() + ":" + selectedInstance.getPort();
    }
}
