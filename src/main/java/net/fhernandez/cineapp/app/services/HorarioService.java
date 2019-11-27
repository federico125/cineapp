package net.fhernandez.cineapp.app.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.fhernandez.cineapp.app.Dao.HorariosDao;
import net.fhernandez.cineapp.app.model.Horario;
import net.fhernandez.cineapp.app.model.pelicula;
import net.fhernandez.cineapp.app.repository.HorarioRepository;

@Service
public class HorarioService implements HorariosDao {
	
	@Autowired
	private HorarioRepository horarioRepository;
	
	@Autowired
	private PeliculasService peliculaService;

	@Override
	public List<Horario> getListPersonalizado(int idPelicula, Date fechaEstreno) {
		// TODO Auto-generated method stub
		return horarioRepository.findByPelicula_IdAndFechaOrderByHora(idPelicula, fechaEstreno);
	}

	@Override
	public List<Horario> getListHorarioPorFecha(Date fecha) {
		List<Horario> getListPelicula = horarioRepository.findByFecha(fecha);
		return getListPelicula;
	}

	@Override
	public void save(Horario horario) {
		if (horario.getPelicula() != null) {
			pelicula pelicula = peliculaService.getById(horario.getPelicula().getId());
			horario.setPelicula(pelicula);
			horarioRepository.save(horario);
		}
	}

	@Override
	public void delete(int idHorario) {
		horarioRepository.deleteById(idHorario);
	}

	@Override
	public Horario getById(int idHorario) {
		Optional<Horario> horario = horarioRepository.findById(idHorario);
		return horario.get();
	}

	@Override
	public List<Horario> getListHorarios() {
		List<Horario> getListHorarios = horarioRepository.findAll();
		return getListHorarios;
	}

	@Override
	public Page<Horario> getListPaginada(Pageable page) {
		Page<Horario> listPaginada = horarioRepository.findAll(page);
		return listPaginada;
	}

}
