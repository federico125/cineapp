package pruebasCrudRepo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.fhernandez.cineapp.app.model.Noticia;
import net.fhernandez.cineapp.app.repository.NoticiasRepository;

public class AppFindAllById {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		List<Integer> listId = new ArrayList<Integer>();
		listId.add(3);
		listId.add(5);
		listId.add(7);
		
		Iterable<Noticia> listNoticias = repo.findAllById(listId);
		for(Noticia n : listNoticias) {
			System.out.println(n);
		}
		
		context.close();
	}
}
