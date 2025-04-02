package com.rsdesenvolvimento.order_service.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

@Configuration
public class FeignOAuth2Config {

  // @Bean
  // public RequestInterceptor requestInterceptor(OAuth2AuthorizedClientManager manager) {
  // return requestTemplate -> {
  // var request = OAuth2AuthorizeRequest.withClientRegistrationId("keycloak")
  // .principal("order-service").build();

  // var client = manager.authorize(request);

  // String token = client.getAccessToken().getTokenValue();
  // requestTemplate.header("Authorization", "Bearer " + token);
  // };
  // }

  @Bean
  public RequestInterceptor requestInterceptor(OAuth2AuthorizedClientManager manager) {
    return requestTemplate -> {
      OAuth2AuthorizeRequest request = OAuth2AuthorizeRequest.withClientRegistrationId("keycloak")
          .principal("order-service").build();

      OAuth2AuthorizedClient client = manager.authorize(request);
      String token = client.getAccessToken().getTokenValue();

      requestTemplate.header("Authorization", "Bearer " + token);
    };
  }
}
