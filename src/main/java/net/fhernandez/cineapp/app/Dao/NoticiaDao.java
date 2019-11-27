package net.fhernandez.cineapp.app.Dao;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.fhernandez.cineapp.app.model.Noticia;

public interface NoticiaDao {
	void save(Noticia noticia);
	void delete(int idNoticia);
	Noticia getById(int IdNoticia);
	List<Noticia> getList();
	List<Noticia>getNoticiaPrincial();
	Page<Noticia> listPaginada(Pageable page);
}
