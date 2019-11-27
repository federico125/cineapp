package net.fhernandez.cineapp.app.controller;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.fhernandez.cineapp.app.model.Banner;
import net.fhernandez.cineapp.app.model.Horario;
import net.fhernandez.cineapp.app.model.Noticia;
import net.fhernandez.cineapp.app.model.pelicula;
import net.fhernandez.cineapp.app.services.BannerService;
import net.fhernandez.cineapp.app.services.HorarioService;
import net.fhernandez.cineapp.app.services.NoticiaService;
import net.fhernandez.cineapp.app.services.PeliculasService;
import net.fhernandez.cineapp.app.util.utileria;

@Controller
public class HomeController {
	
	@Autowired
	private BannerService bannerService;
	
	@Autowired
	private PeliculasService peliculasService;
	
	@Autowired
	private HorarioService horarioService;
	
	@Autowired
	private NoticiaService noticiaService;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	@GetMapping(value = "/home")
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar (@RequestParam("fecha") String fechaBuscar, Model model) throws ParseException {
		Date fechaBusqueda = dateFormat.parse(fechaBuscar);

		List<pelicula> peliculas = peliculasService.getListPorFecha(fechaBusqueda);
		List<String> mostrarFecha = utileria.getNexDays(4);	
		List<Banner> banner = bannerService.getList();
		model.addAttribute("fechas", mostrarFecha);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners", banner);
		model.addAttribute("fechaBusqueda",fechaBuscar);
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) throws ParseException {
		Date fechaEspecifica = dateFormat.parse(dateFormat.format(new Date()));
		List<pelicula> peliculas = peliculasService.getListPorFecha(fechaEspecifica);
		List<Banner> banner = bannerService.getList();
		List<String> mostrarFecha = utileria.getNexDays(4);
		List<Noticia> getListNoticias = noticiaService.getNoticiaPrincial();
		
		/*
		 * peliculas.add("Rapido y furioso"); peliculas.add("El aro 2");
		 * peliculas.add("Alies");
		 */
		model.addAttribute("fechas", mostrarFecha);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners", banner);
		model.addAttribute("listNoticias", getListNoticias);
		model.addAttribute("fechaBusqueda",dateFormat.format(new Date()));
		return "home";
	}
	
	// Url con parametros dinamicos
	/* @RequestMapping(value = "/detail/{id}/{fecha}",method = RequestMethod.GET) */
	
	//Asi se reciben los parametros dinamicos con la anotacion @PathVariable
	//public String mostrarDetalle(Model model, @PathVariable(value = "id") int idPelicula, @PathVariable(value = "fecha") String fecha) {
	 
	
	// De esta manera se reciben parametros de una peticion tipo GET utilizando la anotacion @RequestParam
	@RequestMapping(value = "/detail",method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("idMovi") int idPelicula, @RequestParam("fecha") Date fechaEstreno) {
		model.addAttribute("pelicula", peliculasService.getById(idPelicula));
		model.addAttribute("listaHorarios", horarioService.getListPersonalizado(idPelicula, fechaEstreno));
		model.addAttribute("fechaBusqueda", dateFormat.format(fechaEstreno));
		// TODO - BUSCAR EN LA BASE DE DATOS LOS HORARIOS
		
		return "detalle";
	}
	
	@GetMapping(value = "/acerca")
	String getacerca () {
		return "acerca";
	}
	
	@InitBinder
	public void initBinder (WebDataBinder webDataBinder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}
}