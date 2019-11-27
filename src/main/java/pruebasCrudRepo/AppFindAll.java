package pruebasCrudRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.fhernandez.cineapp.app.model.Noticia;
import net.fhernandez.cineapp.app.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		Iterable<Noticia> noticiaList = repo.findAll();
		
		for(Noticia noticia: noticiaList) {
			System.out.println(noticia);
		}
		
		context.close();

	}

}
