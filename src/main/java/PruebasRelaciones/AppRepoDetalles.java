package PruebasRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.fhernandez.cineapp.app.model.Detalle;
import net.fhernandez.cineapp.app.repository.DetalleRepository;

public class AppRepoDetalles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		DetalleRepository repo = context.getBean("detalleRepository", DetalleRepository.class);
		List<Detalle> detalleList = repo.findAll();
		
		for(Detalle d: detalleList) {
			System.out.println(d);
		}
		
		context.close();

	}

}
