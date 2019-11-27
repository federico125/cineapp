package pruebasCrudRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.fhernandez.cineapp.app.model.Noticia;
import net.fhernandez.cineapp.app.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		for(int i= 0; i < 10; i++) {
			Noticia noticia = new Noticia();
			noticia.setDetalle("Noticia Test" + i);
			noticia.setTitulo("Titulo Noticia test" + i + i);
			repo.save(noticia);
		}
		
		context.close();
	}

}
