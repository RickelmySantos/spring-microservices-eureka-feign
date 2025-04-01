package com.rsdesenvolvimento.user_service.controladores;

import com.rsdesenvolvimento.user_service.modelo.dtos.UsuarioDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioApi {

  @GetMapping("/{id}")
  public UsuarioDto buscarUsuario(@PathVariable Long id) {
    return new UsuarioDto(id, "xpto", "xpto@gmail.com");
  }
}
