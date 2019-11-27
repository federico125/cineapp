package net.fhernandez.cineapp.app.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.fhernandez.cineapp.app.model.Horario;

public interface HorariosDao {
	void save(Horario horario);
	void delete(int idHorario);
	Horario getById(int idHorario);
	List<Horario>getListHorarios();
	List<Horario> getListPersonalizado (int idPelicula, Date fechaEstreno);
	List<Horario> getListHorarioPorFecha (Date fecha);
	Page<Horario> getListPaginada (Pageable page);
}
