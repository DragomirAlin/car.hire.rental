package ro.agilehub.javacourse.car.hire.rental.client.core.impl;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.FleetApi;

import java.util.NoSuchElementException;

@FeignClient(name = "${car.name:car}", url = "${car.url:http://localhost:8080}")
public interface CarApiClient extends FleetApi {
    String CORE = "core";


    @Override
    @CircuitBreaker(name = CORE, fallbackMethod = "coreFallback")
    @RateLimiter(name = CORE)
    @GetMapping(value = "/car/{id}")
    ResponseEntity<CarResponseDTO> getCar(String id);

    default ResponseEntity<CarResponseDTO> coreFallback(Integer id, CallNotPermittedException exception) {
        throw new NoSuchElementException();
    }

    default ResponseEntity<CarResponseDTO> coreFallback(Integer id, Exception exception) {
        throw new RuntimeException();
    }
}

