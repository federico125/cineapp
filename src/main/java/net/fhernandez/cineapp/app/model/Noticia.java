package net.fhernandez.cineapp.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "NOTICIAS")
public class Noticia {
	
	@Id
	@Column(name= "NOTICIAS_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "NOTICIAS_TITULO", length = 250, nullable = false)
	private String titulo;
	
	@Column(name= "NOTICIAS_FECHA", nullable = false)
	private Date fecha = new Date();
	
	@Column(name= "NOTICIAS_DETALLE", nullable = false)
	private String detalle;
	
	@Column(name= "NOTICIAS_ESTATUS", nullable = false)
	private Boolean estatus;
	
	public Noticia() {
		this.fecha = new Date();
		this.estatus = true;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "noticia [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", detalle=" + detalle + ", estatus="
				+ estatus + "]";
	}
	
	
}
