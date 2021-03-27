package com.consulti.persona.service.impl;

import java.util.Date;
import java.util.List;

import com.consulti.persona.config.exception.GenericException;
import com.consulti.persona.entity.Usuario;
import com.consulti.persona.repository.UsuarioRepository;
import com.consulti.persona.service.UsuarioService;
import com.consulti.persona.utils.UtilsGenerales;
import com.consulti.persona.utils.enums.EstadosEnum;
import com.consulti.persona.utils.validations.UsuarioValidations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  @Autowired
  UsuarioRepository usuarioRepo;

  @Autowired
  UsuarioValidations usuarioValidations;

  @Override
  public List<Usuario> listar() throws GenericException {
    List<Usuario> response;
    try {
      UtilsGenerales.validarTamanoLista(usuarioRepo.count());
      response = usuarioRepo.findAll();
    } catch (GenericException e) {
      throw new GenericException(e.getMessageError(), e.getCodeError());
    }
    return response;
  }

  @Override
  public List<Usuario> listarPor(Usuario request) throws GenericException {
    List<Usuario> response;
    try {
      usuarioValidations.validarUsuarioVacio(request);
      Example<Usuario> filtros = Example.of(request);
      response = usuarioRepo.findAll(filtros, Sort.by(Sort.Direction.ASC, Usuario.ID_USUARIO));
    } catch (GenericException e) {
      throw new GenericException(e.getMessageError(), e.getCodeError());
    }
    return response;
  }

  @Override
  public Usuario guardar(Usuario request) throws GenericException {
    Usuario response = new Usuario();
    try {
      request.setEstado(EstadosEnum.ACTIVO.getValorr());
      request.setFechaCreacion(new Date());
      usuarioValidations.validarGuardarUsuario(request);
      response = usuarioRepo.save(request);
    } catch (GenericException e) {
      throw new GenericException(e.getMessageError(), e.getCodeError());
    }
    return response;
  }
}
