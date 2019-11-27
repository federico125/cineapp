package pruebasJpaRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.fhernandez.cineapp.app.repository.NoticiasRepository;

public class AppDeleteAllInBatch {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		repo.deleteAllInBatch();
		context.close();
	}
}
