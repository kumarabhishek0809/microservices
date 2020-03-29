package com.reactive.spring;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class FluxFactoryMethods {

    List<String> names = Arrays.asList("Adam", "Anna", "Jack", "Jenny");

    @Test
    public void fluxUsingIteratable() {
        Flux<String> iteratableFlux = Flux.fromIterable(names);
        StepVerifier.create(iteratableFlux)
                .expectNext("Adam", "Anna", "Jack", "Jenny")
                .verifyComplete();
    }

    @Test
    public void fluxUsingArray() {
        String[] names = new String[]{"Adam", "Anna", "Jack", "Jenny"};
        Flux<String> arrayFlux = Flux.fromArray(names);
        StepVerifier.create(arrayFlux)
                .expectNext("Adam", "Anna", "Jack", "Jenny")
                .verifyComplete();
    }

    @Test
    public void fluxUsingSteam() {
        Flux<String> arrayFlux = Flux.fromStream(names.stream());
        StepVerifier.create(arrayFlux)
                .expectNext("Adam", "Anna", "Jack", "Jenny")
                .verifyComplete();
    }

    @Test
    public void monoOrEmpty() {
        Mono<String> emptyMono = Mono.justOrEmpty(null);

        StepVerifier.create(emptyMono)
                .verifyComplete();
    }

    @Test
    public void fluxFromRange(){
        Flux<Integer> rangeFlux = Flux.range(1, 10);
        StepVerifier.create(rangeFlux)
                .expectNext(1,2,3,4,5,6,7,8,9,10)
                .verifyComplete();
    }
}
