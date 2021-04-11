package info.thecodinglive.resilience4j.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.time.Duration;

@Slf4j
@Configuration
public class CircuitConfig {
    @Value("${apiServer.maxTimeout}")
    private Integer maxTimeout;
    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomer() {
        log.info("maxTimeout check: {}", maxTimeout);
        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder("fastcam-timelimit")
        .timeLimiterConfig(TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(maxTimeout))
                .build())
        .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults()).build());
    }
}
