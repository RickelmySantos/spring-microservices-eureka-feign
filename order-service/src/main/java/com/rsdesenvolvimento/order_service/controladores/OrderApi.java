package com.rsdesenvolvimento.order_service.controladores;

import com.rsdesenvolvimento.order_service.config.UsuarioClient;
import com.rsdesenvolvimento.order_service.dto.UsuarioDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {
  private final UsuarioClient usuarioClient;

  public OrderApi(UsuarioClient usuarioClient) {
    this.usuarioClient = usuarioClient;
  }

  @GetMapping("/{id}")
  public String buscarServico(@PathVariable Long id) {
    UsuarioDto usuarioDto = this.usuarioClient.buscarUsuario(id);
    return "Serviço de pedido chamado por " + usuarioDto.getName();
  }

}
