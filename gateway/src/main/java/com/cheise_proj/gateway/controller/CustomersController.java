package com.cheise_proj.gateway.controller;

import com.cheise_proj.gateway.dto.CustomerDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
public class CustomersController {
    private final WebClient webClient;

    public CustomersController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping(value = "/customers")
    public List<CustomerDto> getArticles(
            @RegisteredOAuth2AuthorizedClient("web-app-client-authorization-code") OAuth2AuthorizedClient authorizedClient
    ) {
        return this.webClient
                .get()
                .uri("http://127.0.0.1:8090/customers")
                .attributes(ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient(authorizedClient))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CustomerDto>>() {
                })
                .block();
    }
}
