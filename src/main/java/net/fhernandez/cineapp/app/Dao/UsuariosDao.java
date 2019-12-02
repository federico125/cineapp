package net.fhernandez.cineapp.app.Dao;
import java.util.List;

import net.fhernandez.cineapp.app.model.Usuarios;

public interface UsuariosDao {
	 List<Usuarios> getList(); 
	 Usuarios getById (int idUsuario);
	 void save (Usuarios usuarios);
	 void delete(int idUsuario);
}
