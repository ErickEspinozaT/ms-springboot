package com.consulti.persona.utils.validations;

import java.util.Optional;

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

  public Usuario validarActualizarUsuario(Usuario request) throws GenericException {
    if (request.getId() == null) {
      throw new GenericException("El valor id es requerido", CoreUtilConstants.MISSING_VALUES);
    }
    if (request.getFechaModificacion() == null) {
      throw new GenericException("El valor fechaModificacion es requerido", CoreUtilConstants.MISSING_VALUES);
    }
    if (!usuarioRepository.existsById(request.getId())) {
      throw new GenericException("El usuario no existe", CoreUtilConstants.EXISTING_VALUES);
    }
    if (usuarioRepository.existsByEmail(request.getEmail())) {
      throw new GenericException("El email no está disponible", CoreUtilConstants.EXISTING_VALUES);
    }
    Optional<Usuario> optionalUsuario = usuarioRepository.findById(request.getId());
    Usuario response = optionalUsuario.orElse(request);
    response.setNombres(request.getNombres() != null ? request.getNombres() : response.getNombres());
    response.setApellidos(request.getApellidos() != null ? request.getApellidos() : response.getApellidos());
    response.setEmail(request.getEmail() != null ? request.getEmail() : response.getEmail());
    response.setContrasena(request.getContrasena() != null ? request.getContrasena() : response.getContrasena());
    response.setUsuario(request.getUsuario() != null ? request.getUsuario() : response.getUsuario());
    response.setEstado(request.getEstado() != null ? request.getEstado() : response.getEstado());
    response.setFechaCreacion(
        request.getFechaCreacion() != null ? request.getFechaCreacion() : response.getFechaCreacion());
    response.setFechaModificacion(
        request.getFechaModificacion() != null ? request.getFechaModificacion() : response.getFechaModificacion());
    return response;
  }
}
