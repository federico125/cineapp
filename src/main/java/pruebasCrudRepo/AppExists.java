package pruebasCrudRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.fhernandez.cineapp.app.repository.NoticiasRepository;

public class AppExists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		int idNoticia = 1;
		
		System.out.println(repo.existsById(idNoticia));
		context.close();
		

	}

}
