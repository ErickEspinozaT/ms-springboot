package com.consulti.persona.service;

import java.util.List;

import com.consulti.persona.config.exception.GenericException;
import com.consulti.persona.entity.Usuario;

import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {
  List<Usuario> listar() throws GenericException;

  List<Usuario> listarPor(Usuario request) throws GenericException;

  Usuario guardar(Usuario request) throws GenericException;
}
