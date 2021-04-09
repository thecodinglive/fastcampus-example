package info.thecodinglive.photoapp.api.post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PostReadController {
    @GetMapping("/v1.0/contents/1")
    public ResponseEntity<?> retriveInMemoryData() {
        Content content = Content.builder()
                .contentId(UUID.randomUUID().toString())
                .body("get data")
                .title("sp gateway test")
                .writerNickName("testnick")
                .build();

        return ResponseEntity.ok(content);
    }

    @GetMapping("/v1.0/contents/2")
    public ResponseEntity<?> throwTimeOut() {
        try {
            Thread.sleep(1000 * 30);
        } catch (Exception e) {

        }
        return ResponseEntity.ok("timeout");
    }
}
