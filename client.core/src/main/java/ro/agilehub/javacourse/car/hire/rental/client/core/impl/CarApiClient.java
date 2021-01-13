package ro.agilehub.javacourse.car.hire.rental.client.core.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.FleetApi;

@FeignClient(name = "${user.name:user}", url = "${user.url:http://localhost:8080}")
public interface CarApiClient extends FleetApi {
    String CORE = "core";

    @CircuitBreaker(name = CORE, fallbackMethod = "coreFallback")
    @RateLimiter(name = CORE)
    @GetMapping(value = "/fleet/{id}")
    default ResponseEntity<CarResponseDTO> getCar(String id) {
        return null;
    }
}
