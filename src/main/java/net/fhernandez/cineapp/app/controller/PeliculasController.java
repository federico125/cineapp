package net.fhernandez.cineapp.app.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.fhernandez.cineapp.app.model.pelicula;
import net.fhernandez.cineapp.app.services.PeliculasService;
import net.fhernandez.cineapp.app.util.utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@Autowired
	private PeliculasService peliculasService;
	
	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<pelicula> list = peliculasService.getList();
		model.addAttribute("peliculas",  list);
		return "peliculas/listPeliculas";
	}
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute pelicula pelicula, Model model) {
		return "peliculas/formPelicula";	
	}
	
	@PostMapping(value = "/save")
	public String guardar(pelicula pelicula, BindingResult result, RedirectAttributes redirectAttributes,
			@RequestParam("archivoImagen") MultipartFile multipartFilter, HttpServletRequest request) {
		
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "peliculas/formPelicula";
		}
		
		if(!multipartFilter.isEmpty()) {
		String nombreImagen = utileria.guardarImagen(multipartFilter, request);	
		pelicula.setImagen(nombreImagen);
		}
		
		/*
		 * for (ObjectError error : result.getAllErrors()) {
		 * System.out.println(error.getDefaultMessage()); }
		 */ 
		  
		peliculasService.save(pelicula);
		  System.out.println("Tamaño2 "+ peliculasService.getList().size());
		  
		  redirectAttributes.addFlashAttribute("mensaje","El registro se ha guardado correctamente");
		  
		//return "peliculas/formPelicula";
		  return "redirect:/peliculas/indexPaginate";
		
	}
	
	@GetMapping(value= "/update/{idPelicula}")
	public String update(@PathVariable("idPelicula") int idPelicula, Model model) {
		pelicula pelicula = peliculasService.getById(idPelicula);
		model.addAttribute("pelicula",pelicula);
		
		return "peliculas/formPelicula";
	}
	
	@GetMapping(value= "/delete/{idPelicula}")
	public String delete(@PathVariable("idPelicula") int idPelicula, RedirectAttributes attributes) {
		peliculasService.delete(idPelicula);
		attributes.addFlashAttribute("mensaje", "La pelicula fue eliminada correctamente!");
		return "redirect:/peliculas/indexPaginate";
	}

	@GetMapping(value = "/indexPaginate")
	public String paginate(Model model, Pageable page) {
		Page<pelicula> listPeliculas = peliculasService.buscaTodas(page);
		model.addAttribute("peliculas",listPeliculas);
		return "peliculas/listPeliculas";
	}
	
	
	//Cuando utilizamos la anotacion ModelAttribute a nivel de la clase de un controlador lo que va a regresar 
	//es un valor que va asignar al atributo que especifiquemos y este atributo va a estar disponible o se puede 
	//utilizar para cuando se ejecute cada metodo en este controlador 
	//De esta forma Estamos agregando un atributo al modelo, 
	//en este caso el atributo genero va a estar disponible para cada metodo de este controlador 
	@ModelAttribute("generos")
	public List<String> getGeneros(){
		return peliculasService.buscarGenero();
	}
	
	@InitBinder
	public void initBinder (WebDataBinder webDataBinder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}

}
