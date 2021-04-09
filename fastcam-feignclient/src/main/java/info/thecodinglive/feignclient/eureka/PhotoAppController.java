package info.thecodinglive.feignclient.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoAppController {

    @Autowired
    PhotoClient photoClient;

    @GetMapping("/photo")
    public String findServer() {
        return photoClient.sayHello();
    }



    @FeignClient("photoapp")  //도메인 정보
    interface PhotoClient {
        @GetMapping("/clients")
        String sayHello();
    }


}
