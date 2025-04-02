package com.rsdesenvolvimento.order_service.config;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class KeycloakConfig {

  private final WebClient webClient;

  public KeycloakConfig(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder
        .baseUrl("http://localhost:8280/realms/dev/protocol/openid-connect/token").build();
  }

  public String getToken() {
    return this.webClient.post().contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .body(BodyInserters.fromFormData("grant_type", "client_credentials")
            .with("client_id", "order-service")
            .with("client_secret", "wBHGh6xFwavHC5w7vKHN2MuKS3zmHS51"))
        .retrieve().bodyToMono(JsonNode.class).map(json -> json.get("access_token").asText())
        .block();
  }
}
