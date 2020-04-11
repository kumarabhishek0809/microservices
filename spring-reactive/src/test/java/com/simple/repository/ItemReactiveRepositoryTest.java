package com.simple.repository;

import com.simple.document.Item;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

@DataMongoTest
@RunWith(SpringRunner.class)
public class ItemReactiveRepositoryTest {
    @Autowired
    private ItemReactiveRepository itemReactiveRepository;

    List<Item> items = Arrays.asList(
            Item.builder().description("Samsung TV").price(400.00).build(),
            Item.builder().description("LG TV").price(420.00).build(),
            Item.builder().description("Apple Watch").price(299.99).build(),
            Item.builder().description("Beats Head Phone").price(410.00).build(),
            Item.builder().id("ABC").description("Bose Head Phone").price(410.00).build()
    );

    @Before
    public void setUp() {
        itemReactiveRepository.deleteAll()
                .thenMany(Flux.fromIterable(items))
                .flatMap(itemReactiveRepository::save).doOnNext(item -> {
            System.out.println("Inserted Item is " + item);
        });
    }

    @Test
    public void getAllItems() {
        StepVerifier.create(itemReactiveRepository.findAll())
                .expectSubscription()
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    public void getItemById() {
        StepVerifier.create(itemReactiveRepository.findById("ABC"))
                .expectSubscription()
                .expectNextMatches( item -> item.getDescription().equals("Bose Head Phone"))
                .verifyComplete();
    }


}
