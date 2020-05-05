package com.reactive.spring;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class FluxAndMonoWithTimeTest {
    @Test
    public void infiniteSequence() throws InterruptedException {
        Flux<Long> infiniteFlux = Flux.interval(Duration.ofMillis(200)).log();
        infiniteFlux.subscribe(element -> {
            System.out.println("Value of "+element);
        });
        Thread.sleep(3000);
    }

    @Test
    public void infiniteSequenceLimit() throws InterruptedException {
        Flux<Long> finiteFlux = Flux.interval(Duration.ofMillis(100)).take(3).log();
        StepVerifier.create(finiteFlux)
                .expectSubscription()
                .expectNext(0L,1L,2L)
                .verifyComplete();
    }

    @Test
    public void infiniteSequenceLimitDelay() throws InterruptedException {
        Flux<Long> finiteFlux = Flux.interval(Duration.ofMillis(100))
                .delayElements(Duration.ofMillis(100))
                .take(3).log();
        StepVerifier.create(finiteFlux)
                .expectSubscription()
                .expectNext(0L,1L,2L)
                .verifyComplete();
    }
}
