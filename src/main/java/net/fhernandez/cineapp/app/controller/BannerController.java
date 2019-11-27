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

import net.fhernandez.cineapp.app.model.Banner;
import net.fhernandez.cineapp.app.services.BannerService;
import net.fhernandez.cineapp.app.util.utileria;

@Controller
@RequestMapping(value = "/banner")
public class BannerController {

	@Autowired
	private BannerService bannerService;

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Banner> list = bannerService.getList();
		model.addAttribute("listBaner", list);
		return "banners/listBanners";
	}
	
	@GetMapping("/indexPaginate")
	public String mostrarListaPaginada(Model model, Pageable page) {
		Page<Banner> listPaginada = bannerService.bannerListPaginado(page);
		model.addAttribute("listBaner", listPaginada);
		return "banners/listBanners";
	}

	@GetMapping("/create")
	public String crear(@ModelAttribute Banner banner) {
		return "banners/formBanner";
	}

	@PostMapping(value = "/save")
	public String save(Banner banner, BindingResult result, RedirectAttributes redirectAttributes,
			@RequestParam("archivoImagen") MultipartFile multipartFilter, HttpServletRequest request) {
		System.out.println(banner);
		
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "banners/formBanner";
		}

		if (!multipartFilter.isEmpty()) {
			String nombreArchivo = utileria.guardarImagen(multipartFilter, request);
			banner.setArchivo(nombreArchivo);
		}

		bannerService.save(banner);
		
		redirectAttributes.addFlashAttribute("mensaje", "El registro se ha guardado correctamente");
		return "redirect:/banner/indexPaginate";
	}
	
	@GetMapping(value ="/update/{idBanner}")
	public String update(@PathVariable("idBanner") int idBanner, Model model) {
		Banner banner = bannerService.getById(idBanner);
		model.addAttribute("banner", banner);
	return "banners/formBanner";
	}
	
	@GetMapping(value="/delete/{idBanner}")
	public String delete(@PathVariable("idBanner") int idBanner, RedirectAttributes redirectAttributes) {
		bannerService.delete(idBanner);
		redirectAttributes.addFlashAttribute("mensaje", "El registro se ha Eliminado correctamente");
		return "redirect:/banner/indexPaginate";
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}
}