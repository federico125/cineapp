package PruebasRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.fhernandez.cineapp.app.model.Horario;
import net.fhernandez.cineapp.app.repository.HorarioRepository;

public class AppRepoHorarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		HorarioRepository repo = context.getBean("horarioRepository", HorarioRepository.class);
		
		List<Horario> horarioList = repo.findAll();
		System.out.println("Numero de entidades " + horarioList.size());
		for(Horario h: horarioList) {
			System.out.println(h);
		}
		
		context.close();

	}

}
