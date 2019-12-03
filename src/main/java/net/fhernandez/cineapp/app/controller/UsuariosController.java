package net.fhernandez.cineapp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.fhernandez.cineapp.app.model.UsuarioPerfil;
import net.fhernandez.cineapp.app.model.Usuarios;
import net.fhernandez.cineapp.app.services.UsuarioPerfilService;
import net.fhernandez.cineapp.app.services.UsuariosService;

@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController {
	
	@Autowired
	private BCryptPasswordEncoder code;
	
	@Autowired
	private UsuariosService usuariosService;
	
	@Autowired
	private UsuarioPerfilService usuarioPerfilService;
	
	@GetMapping(value ="/demo-Bcrypt")
	public String PruebaEncriptarContrasena () {
		String password = "fhernandez";
		String claveEncriptado = code.encode(password);
		System.out.println("Password Encriptado "+ claveEncriptado);
		return "usuarios/demo";
	}
	
	@GetMapping(value = "/create")
	public String crear (@ModelAttribute Usuarios usuarios) {
		return "usuarios/formUsuario";
	}
	
	@GetMapping(value="/index")
	public String index() {
		return "usuarios/listUsuarios";
	}
	
	@PostMapping(value="/save")
	public String save (@ModelAttribute Usuarios usuarios, @RequestParam("perfil") String perfil) {
		
		String passwordTemporal = usuarios.getPassword();
		String passwordEncriptado = code.encode(passwordTemporal);
		
		usuarios.setPassword(passwordEncriptado);
		usuarios.setEstatus(1);
		
		usuariosService.save(usuarios);
		
		UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
		usuarioPerfil.setNombreUsuario(usuarios.getNombreUsuario());
		usuarioPerfil.setRol(perfil);
		usuarioPerfilService.save(usuarioPerfil);
		
		System.out.println(usuarios);
		System.out.println(perfil);
	return "redirect:/usuarios/index";	
	}
}
