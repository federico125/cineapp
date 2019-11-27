package net.fhernandez.cineapp.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.fhernandez.cineapp.app.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {
	public List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fechaEstreno);
	
	@Query("select h from Horario h where h.fecha = :fecha and pelicula.estatus = true group by h.id,h.fecha,h.hora,h.sala,h.precio,h.pelicula order by pelicula.id asc")
	public List<Horario> findByFecha(@Param("fecha") Date fecha);

}
