package info.thecodinglive.photoapp.api.post;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
public class HeadController {
    @GetMapping("/v1.0/headservice")
    public ResponseEntity retriveHeadData(@RequestHeader(value = "X-PHOTO-API-VERSION") String apiVersion) {
        LOG.info("header data: {}", apiVersion);
        return ResponseEntity.ok("ok");
    }
}
