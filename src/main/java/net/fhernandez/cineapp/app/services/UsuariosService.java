package net.fhernandez.cineapp.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fhernandez.cineapp.app.Dao.UsuariosDao;
import net.fhernandez.cineapp.app.model.Usuarios;
import net.fhernandez.cineapp.app.repository.UsuariosRepository;

@Service
public class UsuariosService implements UsuariosDao {
	
	@Autowired
	private UsuariosRepository usuariosRepository;

	@Override
	public List<Usuarios> getList() {
		List<Usuarios> usuariosList = usuariosRepository.findAll();
		return usuariosList;
	}

	@Override
	public Usuarios getById(int idUsuario) {
		Optional<Usuarios> usuario = usuariosRepository.findById(idUsuario);
		return usuario.get();
	}

	@Override
	public void save(Usuarios usuarios) {
		usuariosRepository.save(usuarios);	
	}

	@Override
	public void delete(int idUsuario) {
		usuariosRepository.deleteById(idUsuario);
	}

}
