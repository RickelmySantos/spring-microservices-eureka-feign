package com.rsdesenvolvimento.user_service.modelo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

  private Long id;
  private String name;
  private String email;
}
