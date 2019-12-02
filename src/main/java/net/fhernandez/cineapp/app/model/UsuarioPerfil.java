package net.fhernandez.cineapp.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOPERFIL")
public class UsuarioPerfil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USUARIOPERFIL_ID")
	private int id;
	
	@Column(name = "USUARIOPERFIL_USERNAME")
	private String nombreUsuario;
	
	@Column(name = "USUARIOPERFIL_PERFIL")
	private String rol;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "UsuarioPerfil [id=" + id + ", nombreUsuario=" + nombreUsuario + ", rol=" + rol + "]";
	}
}
