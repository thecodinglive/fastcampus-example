package info.thecodinglive.resilience4j.service.circuit;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CircuitController {

    private final CircuitAnnotationService circuitAnnotationService;
    private final CircuitBreakerFactory circuitBreakerFactory;
    private final HttpBinService httpBin;

    @GetMapping("/get")
    public Map get() {return httpBin.get();}

    @GetMapping("/delay/{seconds}")
    public Map delay(@PathVariable int seconds) {
        return circuitBreakerFactory
                .create("delay").run(httpBin.delaySuppplier(seconds),
                        t -> {
                    log.warn("delay call failed error", t);
                    Map<String, String> fallback = new HashMap<>();
                    fallback.put("hello", "world");
                    return fallback;
                        });
    }

    @GetMapping("/circuit/fail")
    public String requestWithCircuitFail() {
       return circuitAnnotationService.getFailRequest();
    }

    @GetMapping("/circuit/success")
    public String requestWithCircuitSuccess() {
        return circuitAnnotationService.getSuccessRequest();
    }
}
