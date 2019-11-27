package net.fhernandez.cineapp.app.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.fhernandez.cineapp.app.model.Horario;
import net.fhernandez.cineapp.app.model.pelicula;
import net.fhernandez.cineapp.app.services.HorarioService;
import net.fhernandez.cineapp.app.services.PeliculasService;

@Controller
@RequestMapping("/horarios")
public class HorarioController {
	
	@Autowired
	PeliculasService peliculasService;
	
	@Autowired
	HorarioService horarioService;
	
	@GetMapping(value= "/indexPaginate")
	public String home(Model model, Pageable page) {
		Page<Horario> horarioPaginados = horarioService.getListPaginada(page);
		model.addAttribute("horarios", horarioPaginados);
		return "horario/listHorarios";
	}

	@GetMapping("/create")
	public String crear(@ModelAttribute Horario horario, Model model) {
		return "horario/formHorario";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Horario horario, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "horario/formHorario";
		}else {
			horarioService.save(horario);
			redirectAttributes.addFlashAttribute("mensaje", "El horario se ha guardado correctamente");
		}
	
		return "redirect:/horarios/indexPaginate";
	}
	
	@GetMapping(value = "/update/{idHorario}")
	public String update(@PathVariable("idHorario")int idHorario,Model model, RedirectAttributes redirectAttributes) {
		Horario horario = horarioService.getById(idHorario);
		model.addAttribute("horario", horario);
		return "horario/formHorario";
	}
	
	@GetMapping(value ="/delete/{idHorario}")
	public String delete(@PathVariable("idHorario")int idHorario, RedirectAttributes redirectAttributes) {
		horarioService.delete(idHorario);
		redirectAttributes.addFlashAttribute("mensaje", "El horario se ha Eliminado correctamente");
		return "redirect:/horarios/indexPaginate";
	}
	
	@ModelAttribute("peliculas")
	List<pelicula> getListPelicula (){
		return peliculasService.getList();
	}
	
	@InitBinder
	public void initBinder (WebDataBinder webDataBinder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}
}
