package net.fhernandez.cineapp.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name ="PELICULAS")
public class pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PELICULAS_ID")
	private int id;
	
	@Column(name = "PELICULAS_TITULO")
	private String titulo;
	
	@Column(name = "PELICULAS_DURACION")
	private int duracion;
	
	@Column(name = "PELICULAS_CLASIFICACION")
	private String clasificacion;
	
	@Column(name = "PELICULAS_GENERO")
	private String genero;
	
	@Column(name = "PELICULAS_IMAGEN")
	private String imagen= "cinema.png";
	
	@Column(name = "PELICULAS_FECHAESTRENO")
	private Date fechaEstreno;
	
	@Column(name = "PELICULAS_ESTATUS")
	private Boolean estatus = true;
	 
	//@Transient //La anotacion Transient se utiliza para indicarle a JPA que un atributo de una entidad no debe de ser persistente         
	@OneToOne
	@JoinColumn(name = "PELICULAS_DETALLE")
	private Detalle detalle;
	
	//@OneToMany(mappedBy = "pelicula", fetch = FetchType.EAGER)
	//private List<Horario> horarios;
	
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
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}
	public Boolean getEstatus() {
		return estatus;
	}
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	public Detalle getDetalle() {
		return detalle;
	}
	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}
	
	/*
	 * public List<Horario> getHorarios() { return horarios; } public void
	 * setHorarios(List<Horario> horarios) { this.horarios = horarios; }
	 */
	/*
	 * se sobre escribe el metodo toString para mostrar el status del objeto a la
	 * hora de desplegarlo como por ejemplo en un system.out.print
	 */
	@Override
	public String toString() {
		return "pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", clasificacion="
				+ clasificacion + ", genero=" + genero + ", imagen=" + imagen + ", fechaEstreno=" + fechaEstreno
				+ ", estatus=" + estatus + ", detalle=" + detalle + "]";
	}
	
}
