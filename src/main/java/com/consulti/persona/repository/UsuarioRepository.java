package com.consulti.persona.repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.consulti.persona.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
  List<Usuario> findByFechaCreacionBetween(Date fechaInicio, Date fechaFin);

  Boolean existsByEmail(String email);
}
