package info.thecodinglive.resilience4j.service.circuit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.function.Supplier;

@RequiredArgsConstructor
@Service
public class HttpBinService {
    private final RestTemplate rest;

    public Map get() {
        return rest.getForObject("https://httpbin.org/get", Map.class);

    }

    public Map delay(int seconds) {
        return rest.getForObject("https://httpbin.org/delay/" + seconds, Map.class);
    }

    public Supplier<Map> delaySuppplier(int seconds) {
        return () -> this.delay(seconds);
    }
}
