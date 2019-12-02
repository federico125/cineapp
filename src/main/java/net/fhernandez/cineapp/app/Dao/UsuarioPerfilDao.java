package net.fhernandez.cineapp.app.Dao;

import java.util.List;

import net.fhernandez.cineapp.app.model.UsuarioPerfil;

public interface UsuarioPerfilDao {
	 List<UsuarioPerfil> getList(); 
	 UsuarioPerfil getById (int idUsuarioPerfil);
	 void save (UsuarioPerfil usuarioPerfil);
	 void delete(int idUsuarioPerfil);
}
