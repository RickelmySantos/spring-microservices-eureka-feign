package com.rsdesenvolvimento.user_service.services;

import com.rsdesenvolvimento.user_service.modelo.dtos.UsuarioDto;
import com.rsdesenvolvimento.user_service.modelo.entidades.Usuario;
import com.rsdesenvolvimento.user_service.modelo.mappers.UsuarioMapper;
import com.rsdesenvolvimento.user_service.repositorios.UsuarioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
  private final UsuarioRepository repository;
  private final UsuarioMapper mapper;

  public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public UsuarioDto salvar(UsuarioDto dto) {
    Usuario usuario = this.mapper.paraEntidade(dto);
    return this.mapper.paraDto(this.repository.save(usuario));
  }

  public List<UsuarioDto> listar() {
    return this.repository.findAll().stream().map(this.mapper::paraDto).toList();
  }
}
