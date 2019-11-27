package net.fhernandez.cineapp.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fhernandez.cineapp.app.model.pelicula;

@Repository
public interface PeliculasRepository extends JpaRepository<pelicula, Integer> {
	public List<pelicula> findByEstatus_OrderByTitulo(Boolean estado);
}
