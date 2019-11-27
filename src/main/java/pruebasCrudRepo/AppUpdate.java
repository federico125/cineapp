package pruebasCrudRepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.fhernandez.cineapp.app.model.Noticia;
import net.fhernandez.cineapp.app.repository.NoticiasRepository;

public class AppUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		Optional<Noticia> noticia  = repo.findById(1);
		
		if(noticia.isPresent()) {
			Noticia noticiaQuery = noticia.get();
			noticiaQuery.setTitulo("Nuevo titulo");
			repo.save(noticiaQuery);
			System.out.println(noticiaQuery);
		}
		
		context.close();
	}
}
