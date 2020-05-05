package com.simple.config;

import com.simple.document.Item;
import com.simple.repository.ItemReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@Component
public class ItemDataInitializer implements CommandLineRunner {
    @Autowired
    private ItemReactiveRepository itemReactiveRepository;

    @Override
    public void run(String... args) throws Exception {
        initialDataSetUp();
    }

    private void initialDataSetUp() {
        itemReactiveRepository.deleteAll()
                .thenMany(Flux.fromIterable(data()))
                .flatMap(itemReactiveRepository::save)
                .thenMany(itemReactiveRepository.findAll())
                .subscribe( item -> System.out.println("Item Inserted from Command Line"+item));

    }

    private List<Item> data() {
        return Arrays.asList(
                Item.builder().description("Samsung TV").price(400.00).build(),
                Item.builder().description("LG TV").price(420.00).build(),
                Item.builder().description("Apple Watch").price(299.99).build(),
                Item.builder().description("Beats Head Phone").price(410.00).build(),
                Item.builder().id("ABC").description("Bose Head Phone").price(410.00).build()
        );

    }
}
