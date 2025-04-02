package com.rsdesenvolvimento.user_service.config;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;



@Component
public class JwtAuthConverter implements Converter<Jwt, Collection<String>> {
  @Override
  public Collection<String> convert(Jwt jwt) {
    Map<String, Object> realmAccess = jwt.getClaim("realm_access");

    if (realmAccess == null || realmAccess.isEmpty()) {
      return Collections.emptyList();
    }

    return ((List<String>) realmAccess.get("roles")).stream()
        .map(role -> "ROLE_" + role.replace("ROLE_", "")).collect(Collectors.toSet());
  }

  @Bean
  public JwtDecoder jwtDecoder() {
    return NimbusJwtDecoder
        .withJwkSetUri("http://localhost:8280/realms/dev/protocol/openid-connect/certs").build();
  }
}
