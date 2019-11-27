package pruebasQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.fhernandez.cineapp.app.model.Noticia;
import net.fhernandez.cineapp.app.repository.NoticiasRepository;

public class AppKeyWordFindBy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		 NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		 
		//Implementado el metodo buscar lista de noticias por estatus...
		  List<Noticia> noticiaList = repo.findByEstatus(false); 
		  for(Noticia n :noticiaList) { 
			  System.out.println(n); 
			  }
		 
		 
		 
		 //Implementado el metodo buscar lista de noticias por fecha...
		 try {
			 SimpleDateFormat fomato = new SimpleDateFormat("yyyy-MM-dd");
			 List<Noticia> noticiaFechaList = repo.findByFecha(fomato.parse("2019-10-30"));
			 
			 for(Noticia n : noticiaFechaList) {
				 System.out.println(n);
			 }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		

	}

}
