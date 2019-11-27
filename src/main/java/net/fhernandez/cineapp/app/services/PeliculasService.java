package net.fhernandez.cineapp.app.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.fhernandez.cineapp.app.Dao.PeliculaDao;
import net.fhernandez.cineapp.app.model.Detalle;
import net.fhernandez.cineapp.app.model.Horario;
import net.fhernandez.cineapp.app.model.pelicula;
import net.fhernandez.cineapp.app.repository.PeliculasRepository;

@Service
public class PeliculasService implements PeliculaDao {
	
	@Autowired
	private PeliculasRepository peliculasRepository;
	
	@Autowired
	private DetalleService detalleService;
	
	@Autowired
	private HorarioService horarioService;
	
	@Override
	public List<pelicula> getList() {
		List<pelicula> peliculaList = peliculasRepository.findByEstatus_OrderByTitulo(true);
		return peliculaList;
	}

	@Override
	public pelicula getById(int idPelicula) {
		// TODO Auto-generated method stub
		Optional<pelicula> pelicula = peliculasRepository.findById(idPelicula);
		return pelicula.get();
	}

	@Override
	public void save(pelicula pelicula) {
		// TODO Auto-generated method stub
		if(pelicula.getDetalle() != null) {
			detalleService.save(pelicula.getDetalle());
		}
		
		if(pelicula.getEstatus() == null) {
			pelicula.setEstatus(true);	
		}
		
		if(pelicula.getImagen() == null) {
			pelicula.setImagen("cinema.png");
		}
		
		peliculasRepository.save(pelicula);
		
	}
	
	@Override
	public void delete(int idPelicula) {
		pelicula pelicula = this.getById(idPelicula); 

		if (pelicula != null) {
			Detalle detalle = detalleService.getById(pelicula.getDetalle().getId());
			peliculasRepository.deleteById(pelicula.getId());
			detalleService.delete(detalle.getId());
		}
	}
	
	@Override
	public Page<pelicula> buscaTodas(Pageable page) {
		return peliculasRepository.findAll(page);
	}

	@Override
	public List<String> buscarGenero() {
		// TODO Auto-generated method stub
		List<String> generos = new LinkedList<>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		return generos;
	}

	@Override
	public List<pelicula> getListPorFecha(Date fecha) {
		List<pelicula> listPelicula = new LinkedList<>();
		List<Horario> listHorario = horarioService.getListHorarioPorFecha(fecha);
		for(Horario h : listHorario) {
			listPelicula.add(h.getPelicula());
		}
		return listPelicula;
	}

}
