package com.rsdesenvolvimento.user_service.controladores;

import com.rsdesenvolvimento.user_service.modelo.dtos.UsuarioDto;
import com.rsdesenvolvimento.user_service.services.UsuarioService;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/usuarios")
public class UsuarioApi {

  private final UsuarioService service;

  public UsuarioApi(UsuarioService service) {
    this.service = service;
  }

  @PostMapping
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public UsuarioDto criar(@RequestBody UsuarioDto dto) {
    return this.service.salvar(dto);
  }

  @GetMapping
  @PreAuthorize("hasRole('ROLE_USER')")
  public List<UsuarioDto> listar() {
    return this.service.listar();
  }


}
