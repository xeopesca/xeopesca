package com.xeopesca.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xeopesca.webapp.model.dao.UsuarioDAO;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Usuario;

@Controller
public class UsuarioController {
	Usuario user ;
	List users ; 
	
	
	@RequestMapping("/listaUsuarios")
	public String listaUsuarios(Model model) {
		Usuario usuario;
		users = new ArrayList();

		// Busqueda
		UsuarioServicio UserService = new UsuarioServicio();
		users = UserService.listaDeUsuarios();
		
	
		model.addAttribute("users", users);
		return "listaUsuarios";//A saida parsease co tiles
	}
	
	@RequestMapping("/usuarioNovo")
	public String novoUsuario(Model model) {
		users = new ArrayList();

		// Busqueda
		UsuarioServicio UserService = new UsuarioServicio();
		users = UserService.listaDeUsuarios();
		
	
		model.addAttribute("users", users);
		return "usuarioNovo";//A saida parsease co tiles
	}
	
	

}