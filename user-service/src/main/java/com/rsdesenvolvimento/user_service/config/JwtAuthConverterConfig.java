package com.rsdesenvolvimento.user_service.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

@Configuration
public class JwtAuthConverterConfig {

  // @Bean
  // public JwtAuthenticationConverter jwtAuthenticationConverter() {
  // JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
  // jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwt -> {

  // List<String> roles = jwt.getClaimAsMap("realm acess") != null
  // ? (List<String>) ((Map<String, Object>) jwt.getClaimAsMap("realm acess")).get("roles")
  // : List.of();

  // Collection<GrantedAuthority> authorities =
  // roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.toLowerCase()))
  // .collect(Collectors.toList());
  // return authorities;
  // });
  // return jwtAuthenticationConverter;
  // }

  @Bean
  public JwtAuthenticationConverter jwtAuthenticationConverter() {
    JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
    converter.setJwtGrantedAuthoritiesConverter(jwt -> {
      List<String> roles = new ArrayList<>();

      Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
      if (resourceAccess != null && resourceAccess.containsKey("user-service")) {
        Map<String, Object> userService = (Map<String, Object>) resourceAccess.get("user-service");
        roles = (List<String>) userService.get("roles");
      }

      return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()))
          .collect(Collectors.toList());
    });

    return converter;
  }
}
