package pruebasQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.fhernandez.cineapp.app.model.Noticia;
import net.fhernandez.cineapp.app.repository.NoticiasRepository;

public class AppKeyWordOr {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Noticia> listNoticias = new ArrayList<>();
		
		try {
			listNoticias = repo.findByEstatusOrFecha(false, formato.parse("2019-10-30"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Noticia n : listNoticias) {
			System.out.println(n);
		}

	}

}
