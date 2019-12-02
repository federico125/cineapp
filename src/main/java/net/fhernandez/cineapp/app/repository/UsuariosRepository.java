package net.fhernandez.cineapp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.fhernandez.cineapp.app.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {

}
