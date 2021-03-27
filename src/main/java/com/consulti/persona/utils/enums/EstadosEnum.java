package com.consulti.persona.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EstadosEnum {
  ACTIVO("Activo"), INACTIVO("Inactivo"), MODIFICADO("Modificado"), ELIMINADO("Eliminado");

  @Getter
  private String valorr;
}
