package com.consulti.persona.utils.validations;

import com.consulti.persona.config.exception.GenericException;
import com.consulti.persona.entity.Usuario;
import com.consulti.persona.repository.UsuarioRepository;
import com.consulti.persona.utils.constants.CoreUtilConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioValidations {
  @Autowired
  UsuarioRepository usuarioRepository;

  public void validarUsuarioVacio(Usuario request) throws GenericException {
    Usuario objetoNull = new Usuario();
    if (request.equals(objetoNull)) {
      throw new GenericException("Debe declarar variables para filtrar el usuario", CoreUtilConstants.MISSING_VALUES);
    }
  }

  public void validarGuardarUsuario(Usuario request) throws GenericException {
    if (request.getNombres() == null) {
      throw new GenericException("El valor nombres es requerido", CoreUtilConstants.MISSING_VALUES);
    }
    if (request.getApellidos() == null) {
      throw new GenericException("El valor apellidos es requerido", CoreUtilConstants.MISSING_VALUES);
    }
    if (request.getContrasena() == null) {
      throw new GenericException("El valor contraseña es requerido", CoreUtilConstants.MISSING_VALUES);
    }
    if (request.getUsuario() == null) {
      throw new GenericException("El valor usuario es requerido", CoreUtilConstants.MISSING_VALUES);
    }
    if (request.getEmail() == null) {
      throw new GenericException("El valor email es requerido", CoreUtilConstants.MISSING_VALUES);
    }
    if (request.getEstado() == null) {
      throw new GenericException("El valor estado es requerido", CoreUtilConstants.MISSING_VALUES);
    }
    if (request.getFechaCreacion() == null) {
      throw new GenericException("El valor fechaCreacion es requerido", CoreUtilConstants.MISSING_VALUES);
    }
  }
}
