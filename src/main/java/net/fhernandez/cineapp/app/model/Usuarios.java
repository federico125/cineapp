package net.fhernandez.cineapp.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class Usuarios {
	@Id
	@Column(name = "USUARIOS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "USUARIOS_NOMBRE")
	private String nombre;
	
	@Column(name = "USUARIOS_EMAIL")
	private String email;
	
	@Column(name = "USUARIOS_ESTATUS")
	private int estatus;
	
	@Column(name = "USUARIOS_USERNAME")
	private String nombreUsuario;
	
	@Column(name = "USUARIOS_PASSWORD")
	private String Password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", email=" + email + ", estatus=" + estatus
				+ ", nombreUsuario=" + nombreUsuario + ", Password=" + Password + "]";
	}
}
