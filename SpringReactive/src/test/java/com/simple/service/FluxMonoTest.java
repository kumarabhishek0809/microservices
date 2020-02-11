package com.simple.service;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxMonoTest {

    @Test
    public void fluxTest(){
        Flux<String> stringFlux = Flux.just("Spring", "SpringBoot", "ReactiveStream");
        stringFlux.subscribe(System.out::println);
    }
}
