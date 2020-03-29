package com.reactive.spring;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Arrays;

public class FluxAndMonoCombineTest {
    @Test
    public void transformUsingMap() {
        Flux<String> flux1 = Flux.fromIterable(Arrays.asList("A", "B", "C"));
        Flux<String> flux2 = Flux.fromIterable(Arrays.asList("D", "E", "F"));

        Flux<String> merge = Flux.merge(flux1, flux2);

        StepVerifier.create(merge)
                .expectNext("A", "B", "C", "D", "E", "F")
                .verifyComplete();

    }

    @Test
    public void transformUsingMapDelay() {
        Flux<String> flux1 = Flux.fromIterable(Arrays.asList("A", "B", "C")).delayElements(Duration.ofSeconds(1));
        Flux<String> flux2 = Flux.fromIterable(Arrays.asList("D", "E", "F")).delayElements(Duration.ofSeconds(1));

        Flux<String> merge = Flux.merge(flux1, flux2).log();

        StepVerifier.create(merge)
                .expectNextCount(6)
                //.expectNext("A", "B", "C", "D", "E", "F")
                .verifyComplete();

    }
}
