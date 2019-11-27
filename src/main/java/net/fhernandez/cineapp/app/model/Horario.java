package net.fhernandez.cineapp.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "HORARIOS")
public class Horario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HORARIOS_ID")
	private int id;
	
	@Column(name = "HORARIOS_FECHA")
	private Date fecha;
	
	@Column(name = "HORARIOS_HORA")
	private String hora;
	
	@Column(name = "HORARIOS_SALA")
	private String sala;
	
	@Column(name = "HORARIOS_PRECIO")
	private double precio;
	
	//@Transient
	@ManyToOne
	@JoinColumn(name = "HORARIOS_PELICULA")
	private pelicula pelicula;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	@Override
	public String toString() {
		return "Horario [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", sala=" + sala + ", precio=" + precio
				+ ", pelicula=" + pelicula + "]";
	}
	
	
	
}
