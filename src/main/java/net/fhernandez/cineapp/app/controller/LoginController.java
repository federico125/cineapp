package net.fhernandez.cineapp.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
	//Spring obtiene la sesion actual del objeto request para invalidarla
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		//Implementacion de Spring security encargada de destruir la sesión.
		SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
		securityContextLogoutHandler.logout(request, null, null);
		
		//Despues de cerrar la sesión redireccionamos al usuario al formulario de login.
		return "redirect:/formLogin";
	}
	
	//authentication es una interfaz y forma parte de Spring Security
	@GetMapping(value="/index") 
	public String mostrarPrincipalAdmin(Authentication authentication) { 
		//Se recupera el nombre del usuario en la parte del back-end
		System.out.println("username " + authentication.getName());
		return "pagBienvenida"; 
		}

}
