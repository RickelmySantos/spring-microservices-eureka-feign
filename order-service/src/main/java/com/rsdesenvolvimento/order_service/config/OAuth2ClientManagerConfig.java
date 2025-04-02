package com.rsdesenvolvimento.order_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;

@Configuration
public class OAuth2ClientManagerConfig {

  @Bean
  public OAuth2AuthorizedClientManager authorizedClientManager(ClientRegistrationRepository clients,
      OAuth2AuthorizedClientRepository authClients) {
    return new DefaultOAuth2AuthorizedClientManager(clients, authClients);
  }
}
