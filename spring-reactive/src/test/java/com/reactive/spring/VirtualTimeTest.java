package com.reactive.spring;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class VirtualTimeTest {
    @Test
    public void testingWithoutVirtualTime(){
        Flux<Long> finiteFlux = Flux.interval(Duration.ofMillis(1)).take(3).log();
        StepVerifier.create(finiteFlux)
                .expectSubscription()
                .expectNext(0L,1L,2L)
                .verifyComplete();
    }
}
