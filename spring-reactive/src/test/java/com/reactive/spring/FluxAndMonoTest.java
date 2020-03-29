package com.reactive.spring;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FluxAndMonoTest {

    @Test
    public void canTestFlux() {

        Consumer<String> consumer = (t) -> {
            System.out.println(t);
        };
        Consumer<Throwable> errorConsumer = (e) -> {
            System.out.println(e.getMessage());
        };
        Supplier<Exception> exceptionSupplier = () -> {
            return new RuntimeException("Exception Happend");
        };

        Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(exceptionSupplier))
                .concatWith(Flux.just("After Error"))
                .log();

        stringFlux.subscribe(consumer, errorConsumer);
    }


    @Test
    public void canTestStepVerifier() {
        Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .log();

        StepVerifier.create(stringFlux)
                .expectNext("Spring")
                .expectNext("Spring Boot")
                .expectNext("Reactive Spring")
                .verifyComplete();
    }


    @Test
    public void canVerifyStepCount() {
        Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("")))
                .log();

        StepVerifier.create(stringFlux)
                .expectNextCount(3)
                .expectError();
    }

    @Test
    public void canValidateMono() {
        Mono<String> spring = Mono.just("Spring");
        StepVerifier.create(spring).expectNextCount(1);
    }

    @Test
    public void canValidateMonoException() {
        Mono<String> spring = Mono.error(new RuntimeException());
        StepVerifier.create(spring).expectError();
    }
}
