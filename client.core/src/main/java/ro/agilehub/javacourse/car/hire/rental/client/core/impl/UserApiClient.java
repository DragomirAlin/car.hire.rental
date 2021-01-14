package ro.agilehub.javacourse.car.hire.rental.client.core.impl;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import ro.agilehub.javacourse.car.hire.rental.client.core.model.UserResponseDTO;
import ro.agilehub.javacourse.car.hire.rental.client.core.specification.UserApi;

import java.util.NoSuchElementException;

@FeignClient(name = "${user.name:user}", url = "${user.url:http://localhost:8080}")
public interface UserApiClient extends UserApi {
    String CORE = "core";

    @Override
    @CircuitBreaker(name = CORE, fallbackMethod = "coreFallback")
    @RateLimiter(name = CORE)
    @GetMapping(value = "/user/{id}")
    default ResponseEntity<UserResponseDTO> getUser(String id) {
        return null;
    }

    default ResponseEntity<UserResponseDTO> coreFallback(Integer id, CallNotPermittedException exception) {
        throw new NoSuchElementException();
    }

    default ResponseEntity<UserResponseDTO> coreFallback(Integer id, Exception exception) {
        throw new RuntimeException();
    }
}