package net.fhernandez.cineapp.app.Dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.fhernandez.cineapp.app.model.pelicula;

public interface PeliculaDao {
	 List<pelicula> getList(); 
	 pelicula getById (int idPelicula);
	 void save (pelicula pelicula);
	 List<String> buscarGenero ();
	 void delete(int idPelicula);
	 Page<pelicula> buscaTodas(Pageable page);
	 List<pelicula> getListPorFecha(Date fecha);
	 
}
