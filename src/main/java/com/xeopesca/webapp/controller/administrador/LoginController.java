package com.xeopesca.webapp.controller.administrador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Usuario;


@Controller
public class LoginController {
	
	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	// ENTRADA FORMULARIO
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String novoUsuario(Model model, Usuario usuario) {
		model.addAttribute("usuario", usuario);

		return "login";
	}

	
	
//	// SAIDA FORMULARIO
//	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
//	public String login (@Valid Usuario usuario,BindingResult result, Model model) {
//		
//
//		if (UsuarioServicio.login(usuario)){
//			model.addAttribute("user", usuario);
//			return "redirect:/spring/listaUsuarios";
//		}
//		usuario.setContrasinal("");
//		return "login";
//	}
	
	
	// SAIDA FORMULARIO
		@RequestMapping(value = "/loginProcess")
		public String login (Model model) {
			String saida ="login";
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String name = auth.getName();
			
			Usuario user = UsuarioServicio.getUsuario(name);
				
			if (user.getTipousuario().equals("ROLE_ADMIN"))
			{
				saida = "redirect:/spring/listaUsuarios";
			}else if (user.getTipousuario().equals("ROLE_ARMADOR"))
			{
				saida = "redirect:/spring/indexArmador";
			}else if (user.getTipousuario().equals("ROLE_PATRON")){
				saida = "redirect:/spring/indexPatron";
			}else if  (user.getTipousuario().equals("ROLE_ADMINISTRACION")) {
				saida = "redirect:/spring/indexAdministracion";
			}
			
			
			return saida;
		}
	
	//

	
}