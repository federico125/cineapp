package net.fhernandez.cineapp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController {
	
	@Autowired
	private BCryptPasswordEncoder code;
	
	@GetMapping(value ="/demo-Bcrypt")
	public String PruebaEncriptarContrasena () {
		String password = "fhernandez";
		String claveEncriptado = code.encode(password);
		System.out.println("Password Encriptado "+ claveEncriptado);
		return "usuarios/demo";
	}
}
