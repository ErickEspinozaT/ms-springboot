package com.consulti.persona.controller;

import com.consulti.persona.config.response.GenericBasicResponse;
import com.consulti.persona.config.response.GenericListResponse;
import com.consulti.persona.entity.Usuario;
import com.consulti.persona.service.UsuarioService;
import com.consulti.persona.utils.constants.PersonaConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ PersonaConstants.PERSONA_URL })
public class UsuarioController {
  Logger log = LogManager.getLogger(this.getClass());

  @Autowired
  UsuarioService usuarioService;

  @GetMapping(path = { PersonaConstants.LISTA }, produces = MediaType.APPLICATION_JSON_VALUE)
  public GenericListResponse<Usuario> listar() throws Exception {
    GenericListResponse<Usuario> response = new GenericListResponse<>();
    log.info("Mensaje de prueba, {}, {}", PersonaConstants.PERSONA_URL, PersonaConstants.LISTA);
    response.setData(usuarioService.listar());
    return response;
  }

  @PostMapping(path = { PersonaConstants.LISTA_POR })
  public GenericListResponse<Usuario> listarPor(@RequestBody Usuario request) throws Exception {
    GenericListResponse<Usuario> response = new GenericListResponse<>();
    log.info("Mensaje de prueba, {}, {}", PersonaConstants.PERSONA_URL, PersonaConstants.LISTA_POR);
    response.setData(usuarioService.listarPor(request));
    return response;
  }

  @PostMapping(path = { PersonaConstants.GUARDAR })
  public GenericBasicResponse<Usuario> guardar(@RequestBody Usuario request) throws Exception {
    GenericBasicResponse<Usuario> response = new GenericBasicResponse<>();
    log.info("Mensaje de prueba, {}, {}", PersonaConstants.PERSONA_URL, PersonaConstants.GUARDAR);
    response.setData(usuarioService.guardar(request));
    return response;
  }

  @PostMapping(path = { PersonaConstants.ACTUALIZAR })
  public GenericBasicResponse<Usuario> actualizar(@RequestBody Usuario request) throws Exception {
    GenericBasicResponse<Usuario> response = new GenericBasicResponse<>();
    log.info("Mensaje de prueba, {}, {}", PersonaConstants.PERSONA_URL, PersonaConstants.ACTUALIZAR);
    response.setData(usuarioService.actualizar(request));
    return response;
  }

  @PostMapping(path = { PersonaConstants.ELIMINAR })
  public GenericBasicResponse<Boolean> eliminar(@RequestBody Usuario request) throws Exception {
    GenericBasicResponse<Boolean> response = new GenericBasicResponse<>();
    log.info("Mensaje de prueba, {}, {}", PersonaConstants.PERSONA_URL, PersonaConstants.ELIMINAR);
    response.setData(usuarioService.eliminar(request));
    return response;
  }
}
