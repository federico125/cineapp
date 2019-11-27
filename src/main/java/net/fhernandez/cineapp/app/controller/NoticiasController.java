package net.fhernandez.cineapp.app.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.fhernandez.cineapp.app.model.Banner;
import net.fhernandez.cineapp.app.model.Noticia;
import net.fhernandez.cineapp.app.services.NoticiaService;

@Controller
@RequestMapping(value = "/noticias")
public class NoticiasController {
	
	@Autowired
	private NoticiaService noticiaService;
	
	@GetMapping(value = "paginateIndex")
	public String listaIndex(Model model, Pageable page) {
		Page<Noticia> listPage = noticiaService.listPaginada(page);
		model.addAttribute("noticiaList", listPage);
	
		return "noticias/listNoticias";
	}
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Noticia noticia) {
		return"noticias/formNoticia";
	}
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Noticia noticia, BindingResult result, RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "noticias/formNoticia";
		}else {
			noticiaService.save(noticia);
			redirectAttributes.addFlashAttribute("mensaje", "La noticia se ha guardado correctamente");
		}
		
		return"redirect:/noticias/paginateIndex";
	}
	
	@GetMapping(value ="/update/{idNoticia}")
	public String update(@PathVariable("idNoticia") int idNoticia, Model model) {
		Noticia noticia = noticiaService.getById(idNoticia);
		model.addAttribute("noticia", noticia);
	return "noticias/formNoticia";
	}
	
	@GetMapping(value="/delete/{idNoticia}")
	public String delete(@PathVariable("idNoticia") int idNoticia, RedirectAttributes redirectAttributes) {
		noticiaService.delete(idNoticia);
		redirectAttributes.addFlashAttribute("mensaje", "El registro se ha Eliminado correctamente");
		return "redirect:/noticias/paginateIndex";
	}
	
	@InitBinder
	public void initBinder (WebDataBinder webDataBinder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}
}
