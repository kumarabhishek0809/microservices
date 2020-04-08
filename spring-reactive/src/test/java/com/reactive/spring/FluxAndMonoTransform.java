package com.reactive.spring;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class FluxAndMonoTransform {

    List<String> names = Arrays.asList("Adam", "Anna", "Jack", "Jenny");

    @Test
    public void transformUsingMap() {
        Flux<String> iteratableFlux = Flux.fromIterable(names)
                .map(s -> s.toUpperCase())
                .log();

        StepVerifier.create(iteratableFlux)
                .expectNext("ADAM", "ANNA", "JACK", "JENNY")
                .verifyComplete();
    }


    @Test
    public void transformUsingMapLength() {
        Flux<Integer> iteratableFlux = Flux.fromIterable(names)
                .map(s -> s.length())
                .log();

        StepVerifier.create(iteratableFlux)
                .expectNext(4, 4, 4, 5)
                .verifyComplete();
    }


    @Test
    public void transformUsingMapLengthRepeat() {
        Flux<Integer> iteratableFlux = Flux.fromIterable(names)
                .map(s -> s.length())
                .repeat()
                .log();

        StepVerifier.create(iteratableFlux)
                .expectNext(4, 4, 4, 5, 4, 4, 4, 5)
                .expectNext(4);
    }

    @Test
    public void transformUsingMapLengthRepeatUpperCase() {
        Flux<String> iteratableFlux = Flux.fromIterable(names)
                .filter(s -> s.length() > 4)
                .map(s -> s.toUpperCase())
                .log();

        StepVerifier.create(iteratableFlux)
                .expectNext("JENNY")
                .verifyComplete();
    }

    @Test
    public void transformUsingToMap() {
        Flux<String> iteratableFlux = Flux.fromIterable(Arrays.asList("A", "B", "C", "D", "E", "F"))
                .flatMap(s -> {
                    return Flux.fromIterable(convertToList(s));
                }).log();

        StepVerifier.create(iteratableFlux)
                .expectNextCount(2);
    }



    private List<String> convertToList(String s) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(s, "newValue");
    }
}
