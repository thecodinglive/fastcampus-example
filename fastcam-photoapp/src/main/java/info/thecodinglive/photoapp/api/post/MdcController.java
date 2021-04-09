package info.thecodinglive.photoapp.api.post;

import info.thecodinglive.photoapp.config.MDCKeys;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MdcController {
    @GetMapping("/v1/mdc")
    public ResponseEntity getData() {
        String requestId = MDC.get(MDCKeys.REQUEST_ID.getPropertyKey());
        String clientIP = MDC.get(MDCKeys.CLIENT_IP.getPropertyKey());
        String userAgent = MDC.get(MDCKeys.USER_AGENT.getPropertyKey());

        LOG.info("requestId: {} clientIP: {} userAgent {}", requestId, clientIP, userAgent);

        return ResponseEntity.ok("ok");
    }
}
