package com.consulti.persona.utils;

import com.consulti.persona.config.exception.GenericException;
import com.consulti.persona.utils.constants.CoreUtilConstants;

import org.springframework.stereotype.Component;

@Component
public class UtilsGenerales {
  public static void validarTamanoLista(long tamano) throws GenericException {
    if (tamano > 10) {
      throw new GenericException("Tamaño máximo de lista excedido", CoreUtilConstants.INFORMATIVE_VALUES);
    }
  }
}
