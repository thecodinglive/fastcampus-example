package info.thecodinglive.resilience4j.service.circuit;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
@Slf4j
public class CircuitAnnotationService {
    @Value("${apiServer.url}")
    private String apiUrl;

    private RestTemplate restTemplate;

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "defaultFallback")
    public String getFailRequest() {
        //return restTemplate.getForObject(apiUrl + "/circuit/error", String.class);
        throw new MyException("myException");
    }

    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "defaultFallback")
    public String getSuccessRequest() {
        return "request is success";
    }



    public String defaultFallback(MyException e) {
        log.error("default fallback ", e);
        return "fallback msg";
    }

    public String defaultFallback(CallNotPermittedException callNotPermittedException) {
        log.error("default fallback ", callNotPermittedException);
        return "call not permit fallback msg";
    }
}
