package ro.agilehub.javacourse.car.hire.rental.client.core.impl;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.CarResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.FleetApi;

import java.util.NoSuchElementException;

import static ro.agilehub.javacourse.car.hire.rental.client.core.CoreClientConstants.CORE;

@FeignClient(name = "${car.name:car}", url = "${car.url:http://localhost:8080}")
public interface CarApiClient extends FleetApi {

    @Override
    @CircuitBreaker(name = CORE, fallbackMethod = "coreFallback")
    @RateLimiter(name = CORE)
    @GetMapping(value = "/fleet/{id}")
    ResponseEntity<CarResponseDTO> getCar(@PathVariable("id") String id);


    default ResponseEntity<CarResponseDTO> coreFallback(String id, CallNotPermittedException exception) {
        throw new NoSuchElementException();
    }

    default ResponseEntity<CarResponseDTO> coreFallback(String id, Exception exception) {
        throw new RuntimeException();
    }
}