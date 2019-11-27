package net.fhernandez.cineapp.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.fhernandez.cineapp.app.model.Noticia;

@Repository
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {
	
	//Select *from Noticias
	List<Noticia> findBy();
	
	//Select *from Noticias where estatus = ?;
	List<Noticia> findByEstatus(Boolean status);
	
	//Select *from Noticias where fecha = ?;
	List<Noticia> findByFecha (Date date);
	
	//buscar por status y por fecha 
	//Select *from Noticias where fecha = ? and fecha = ?;
	List<Noticia> findByEstatusAndFecha(Boolean status, Date fecha);
	
	//buscar por staus o por fecha 
	//Select *from Noticias where fecha = ? or fecha = ?;
	List<Noticia> findByEstatusOrFecha(Boolean status, Date fecha);
	
	//Select *from Noticias fecha Betwee  ? and ?;
	List<Noticia> findByFechaBetween(Date fecha1, Date fecha2);
	
	List<Noticia> findTop4ByEstatusOrderByIdDesc(Boolean estatus);

}

