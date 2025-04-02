package com.rsdesenvolvimento.order_service.config;

import com.rsdesenvolvimento.order_service.dto.UsuarioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UsuarioClient {

  @GetMapping("api/usuarios/interno/{id}")
  UsuarioDto buscarUsuario(@PathVariable Long id);
}
