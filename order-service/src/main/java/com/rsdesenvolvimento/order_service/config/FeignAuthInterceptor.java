package com.rsdesenvolvimento.order_service.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignAuthInterceptor implements RequestInterceptor {

  private final KeycloakConfig keycloakConfig;

  public FeignAuthInterceptor(KeycloakConfig keycloakConfig) {
    this.keycloakConfig = keycloakConfig;
  }


  @Override
  public void apply(RequestTemplate template) {
    String token = this.keycloakConfig.getToken();
    System.out.println("🔐 TOKEN ENVIADO PELO FEIGN: " + token);
    template.header("Authorization", "Bearer " + token);
  }


}
