package com.consulti.persona.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.consulti.persona.utils.constants.PersonaConstants;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario", schema = PersonaConstants.PERSONA_SCHEMA)
public class Usuario {
  @Id
  @GeneratedValue
  @Column(name = "id", unique = true, updatable = false)
  private UUID id;

  @Column(name = "nombres")
  private String nombres;

  @Column(name = "apellidos")
  private String apellidos;

  @Column(name = "usuario")
  private String usuario;

  @Column(name = "email")
  private String email;

  @Column(name = "contrasena")
  private String contrasena;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = PersonaConstants.TIMEZONE)
  @Column(name = "fecha_creacion")
  private Date fechaCreacion;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = PersonaConstants.TIMEZONE)
  @Column(name = "fecha_modificacion")
  private Date fechaModificacion;

  @Column(name = "estado")
  private String estado;

  public static final String ID_USUARIO = "id";
}
