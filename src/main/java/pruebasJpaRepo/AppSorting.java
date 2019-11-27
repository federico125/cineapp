package pruebasJpaRepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import net.fhernandez.cineapp.app.model.Noticia;
import net.fhernandez.cineapp.app.repository.NoticiasRepository;

public class AppSorting {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		 //Obtener todas las unidades ordenadas por un campo sea Descendene y Ascendente
		//Orden Descendente
		/*
		 * List<Noticia> listNoticiasDes = repo.findAll(Sort.by("titulo").descending());
		 * for(Noticia n: listNoticiasDes) { System.out.println(n); }
		 */
		
		//Orden Ascendente
		/*
		 * List<Noticia> listNoticiasAsc = repo.findAll(Sort.by("titulo")); for(Noticia
		 * n: listNoticiasAsc) { System.out.println(n); }
		 */
		
		//Obtener todas las unidades ordenadas por 2 campo sea Descendene y Ascendente ambos se pueden combinar 
		/*
		 * List<Noticia> listNoticias =
		 * repo.findAll(Sort.by("fecha").ascending().and(Sort.by("titulo").descending())
		 * ); for(Noticia n: listNoticias) { System.out.println(n); }
		 */
		
		//Obtener todas las entidades por paginación
		/*
		 * Page<Noticia> noticiasPaginadas = repo.findAll(PageRequest.of(0, 20));
		 * for(Noticia noticia : noticiasPaginadas) { System.out.println(noticia); }
		 */
		
		//Obtener todas las entidades por paginación y ordenadas por un campo en particular de forma desendente o de forma ascendente.
		Page<Noticia> noticiasPaginadas = repo.findAll(PageRequest.of(0, 4,Sort.by("titulo").descending()));
		for(Noticia noticia : noticiasPaginadas) {
			System.out.println(noticia);
		}
		
		context.close();
	}
}
