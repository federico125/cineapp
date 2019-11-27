package net.fhernandez.cineapp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fhernandez.cineapp.app.model.Detalle;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Integer> {

}
