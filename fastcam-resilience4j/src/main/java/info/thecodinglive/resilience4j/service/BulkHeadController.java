package info.thecodinglive.resilience4j.service;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@RestController
@Slf4j
public class BulkHeadController {

    private final RestTemplate restTemplate;
    private final String provideUrl;
    private final Bulkhead bulkhead;

    public BulkHeadController(RestTemplate restTemplate, @Value("${apiServer.url}") String provideUrl,
                              @Value("${apiServer.maxConcurrent}") int maxConcurrent) {
        this.restTemplate = restTemplate;
        this.provideUrl = provideUrl;
        log.info("maxCounccurent: {}", maxConcurrent);
        this.bulkhead = createBulkHead(maxConcurrent);
    }

    private Bulkhead createBulkHead(Integer maxConcurrent) {
        BulkheadConfig bulkheadConfig = BulkheadConfig.custom()
                .maxConcurrentCalls(maxConcurrent)
                .maxWaitDuration(Duration.ofMillis(500))
                .build();

        Bulkhead bulkhead = Bulkhead.of("resilience-provider", bulkheadConfig);

        bulkhead.getEventPublisher()
                .onCallPermitted(event -> log.info("Call permitted by bulkhead"))
                .onCallRejected(event -> log.info("Call rejected by bulkhead"));

        return bulkhead;
    }


    @GetMapping("/bulkhead")
    public String bulkhead() {
        CheckedFunction0<String> someServiceCall = Bulkhead.decorateCheckedSupplier(bulkhead,
                () -> "this message was" + restTemplate.getForObject(provideUrl + "/slow", String.class));

        Try<String> result = Try.of(someServiceCall).recover((throwable -> "this is a bulkhead fallback"));
        return result.get();
    }
}
