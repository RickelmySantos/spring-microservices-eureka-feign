package com.rsdesenvolvimento.user_service.controladores;

import com.rsdesenvolvimento.user_service.modelo.dtos.UsuarioDto;
import com.rsdesenvolvimento.user_service.services.UsuarioService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ROLE_USER')")
  public UsuarioDto buscarPorId(@PathVariable Long id) {
    return this.service.buscarPorId(id);
  }

  @PreAuthorize("hasRole('ROLE_ORDER_SERVICE')")
  @GetMapping("/interno/{id}")
  public UsuarioDto buscarPorIdInterno(@PathVariable Long id) {
    var auth = SecurityContextHolder.getContext().getAuthentication();
    System.out.println("Auth name: " + auth.getName());
    System.out.println("Authorities: " + auth.getAuthorities());
    return this.service.buscarPorId(id);
  }
}
