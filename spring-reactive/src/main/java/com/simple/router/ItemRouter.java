package com.simple.router;

import com.simple.handler.ItemHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.simple.constants.ItemConstans.V1_ALL_ITEMS_FUCTIONAL;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class ItemRouter {

    @Bean
    public RouterFunction<ServerResponse> itemsRoute(ItemHandler itemHandler) {

        return RouterFunctions
                .route(GET(V1_ALL_ITEMS_FUCTIONAL).and(accept(MediaType.APPLICATION_JSON)),itemHandler::getAllItems)
                .andRoute(GET(V1_ALL_ITEMS_FUCTIONAL+"/{id}").and(accept(MediaType.APPLICATION_JSON)),itemHandler::getItem)
                .andRoute(DELETE(V1_ALL_ITEMS_FUCTIONAL+"/{id}").and(accept(MediaType.APPLICATION_JSON)),itemHandler::deleteItem);
    }
}
