package net.fhernandez.cineapp.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.fhernandez.cineapp.app.model.Contacto;
import net.fhernandez.cineapp.app.services.PeliculasService;


@Controller
public class ContactoController {
	@Autowired
	PeliculasService peliculasService;
	
	@GetMapping("/contacto")
	public String mostrarFormulario(@ModelAttribute("instancia") Contacto contacto, Model model) {
		model.addAttribute("generos", peliculasService.buscarGenero());
		model.addAttribute("notificaciones", this.getListNotificaciones());
		return"contacto/formContacto";
	}
	
	@PostMapping("/contacto")
	public String save(@ModelAttribute("instancia") Contacto contacto) {
		System.out.println(contacto);
		return "redirect:/contacto";
	}
	
	private List<String> getListNotificaciones (){
		List<String> litNotificaciones = new LinkedList<String>();
		litNotificaciones.add("Estrenos");
		litNotificaciones.add("Promociones");
		litNotificaciones.add("Noticias");
		litNotificaciones.add("Preventas");
		return litNotificaciones;
	}

}
