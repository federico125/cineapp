package PruebasRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.fhernandez.cineapp.app.model.pelicula;
import net.fhernandez.cineapp.app.repository.PeliculasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		PeliculasRepository repo = context.getBean("peliculasRepository", PeliculasRepository.class);
		
		List<pelicula> peliculaList = repo.findAll();
		
		for(pelicula p : peliculaList) {
			System.out.println(p);
		}
		
		context.close();
	}
}
