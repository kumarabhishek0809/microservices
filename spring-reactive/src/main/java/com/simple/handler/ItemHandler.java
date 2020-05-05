package com.simple.handler;

import com.simple.document.Item;
import com.simple.repository.ItemReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class ItemHandler {

    static Mono<ServerResponse> notFound = ServerResponse.notFound().build();
    @Autowired
    ItemReactiveRepository itemReactiveRepository;

    public Mono<ServerResponse> getAllItems(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(itemReactiveRepository.findAll(), Item.class);

    }

    public Mono<ServerResponse> getItem(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<Item> itemReactiveRepositoryById = itemReactiveRepository.findById(id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromObject(itemReactiveRepositoryById)).switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> deleteItem(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        Mono<Void> voidMono = itemReactiveRepository.deleteById(id);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(voidMono, Void.class);
    }
}
