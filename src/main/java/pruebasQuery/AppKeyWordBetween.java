package pruebasQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.fhernandez.cineapp.app.model.Noticia;
import net.fhernandez.cineapp.app.repository.NoticiasRepository;

public class AppKeyWordBetween {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Noticia> noticiaList = new ArrayList<>();
		
		try {
			noticiaList = repo.findByFechaBetween(formato.parse("2019-10-28"), formato.parse("2019-11-04"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Noticia n : noticiaList) {
			System.out.println(n);
		}

	}

}
