package net.fhernandez.cineapp.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fhernandez.cineapp.app.Dao.UsuarioPerfilDao;
import net.fhernandez.cineapp.app.model.UsuarioPerfil;
import net.fhernandez.cineapp.app.repository.UsuarioPerfilRepository;

@Service
public class UsuarioPerfilService implements UsuarioPerfilDao {

	@Autowired
	private UsuarioPerfilRepository usuarioPerfilRepository;
	
	@Override
	public List<UsuarioPerfil> getList() {
		List<UsuarioPerfil> usuarioPerfilList = usuarioPerfilRepository.findAll();
		return usuarioPerfilList;
	}

	@Override
	public UsuarioPerfil getById(int idUsuarioPerfil) {
		Optional<UsuarioPerfil> usuarioPerfil = usuarioPerfilRepository.findById(idUsuarioPerfil);
		return usuarioPerfil.get();
	}

	@Override
	public void save(UsuarioPerfil usuarioPerfil) {
		usuarioPerfilRepository.save(usuarioPerfil);
		
	}

	@Override
	public void delete(int idUsuarioPerfil) {
		usuarioPerfilRepository.deleteById(idUsuarioPerfil);
	}

}
