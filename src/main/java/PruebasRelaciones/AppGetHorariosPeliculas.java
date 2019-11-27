package PruebasRelaciones;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.fhernandez.cineapp.app.model.pelicula;
import net.fhernandez.cineapp.app.repository.PeliculasRepository;

public class AppGetHorariosPeliculas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		PeliculasRepository repo = context.getBean("peliculasRepository", PeliculasRepository.class);
		
		Optional<pelicula> pelicula = repo.findById(6);
		/* System.out.println(pelicula.get().getHorarios()); */
		context.close();

	}

}
