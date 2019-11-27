package net.fhernandez.cineapp.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.fhernandez.cineapp.app.Dao.NoticiaDao;
import net.fhernandez.cineapp.app.model.Noticia;
import net.fhernandez.cineapp.app.repository.NoticiasRepository;

@Service
public class NoticiaService implements NoticiaDao {
	
	@Autowired
	NoticiasRepository noticiasRepository;

	@Override
	public List<Noticia> getNoticiaPrincial() {
		List<Noticia> getNoticiaList = noticiasRepository.findTop4ByEstatusOrderByIdDesc(true);
		return getNoticiaList;
	}

	@Override
	public void save(Noticia noticia) {
		noticiasRepository.save(noticia);
	}

	@Override
	public void delete(int idNoticia) {
		noticiasRepository.deleteById(idNoticia);	
	}

	@Override
	public Noticia getById(int idNoticia) {
		Optional<Noticia> noticia = noticiasRepository.findById(idNoticia);
		return noticia.get();
	}

	@Override
	public List<Noticia> getList() {
		List<Noticia> noticiaList = noticiasRepository.findAll();
		return noticiaList;
	}

	@Override
	public Page<Noticia> listPaginada(Pageable page) {
		Page<Noticia> listaPaginada = noticiasRepository.findAll(page); 
		return listaPaginada;
	}

}
