package com.rsdesenvolvimento.user_service.modelo.mappers;

import com.rsdesenvolvimento.user_service.modelo.dtos.UsuarioDto;
import com.rsdesenvolvimento.user_service.modelo.entidades.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

  UsuarioDto paraDto(Usuario usuario);

  Usuario paraEntidade(UsuarioDto usuarioDto);

}
