/* --------------------------------------------------------------------
 This file is part of xeoPesca

Copyright (C) 2013 - Pablo Belay Fernández 
This program is free software: you can redistribute it
and/or modify it under the terms of the GNU General
Public License as published by the Free Software
Foundation, either version 3 of the License, or (at your
option) any later version.
This program is distributed in the hope that it will be
useful, but WITHOUT ANY WARRANTY; without even the
implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE. See the GNU General Public License
for more details.
You should have received a copy of the GNU General Public
License along with this program. If not, see
http://www.gnu.org/licenses/gpl-3.0-standalone.html
--------------------------------------------------------------------*/
package com.xeopesca.webapp.controller.administrador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Usuario;


/**
 * @author belay
 *
 */
@Controller
@SessionAttributes("idArmador")
public class LoginController {

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	/**
	 * Realiza o login na aplicación
	 * @param model
	 * @param usuario
	 * @return String
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String novoUsuario(Model model, Usuario usuario) {
	
		model.addAttribute("usuario", usuario);
		return "login";
	}

	/**
	 * Procesa se se realiza o login correctamente.
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/loginProcess")
	public String login(Model model) {
		String saida = "login";
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();

		Usuario user = UsuarioServicio.getUsuario(name);

		if (user.getTipousuario().equals("ROLE_ADMIN")) {
			saida = "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/admin/listaUsuarios";
		} else if (user.getTipousuario().equals("ROLE_ARMADOR")) {
			//Cargamos en sesion o id do Armador para poder ser validado
			model.addAttribute("idArmador",user.getId());
			saida = "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/armador";
		} else if (user.getTipousuario().equals("ROLE_PATRON")) {
			saida = "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/patron";
		} else if (user.getTipousuario().equals("ROLE_ADMNISTRACION")) {
			saida = "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/indexAdministracion";
		}

		return saida;
	}

	/**
	 * Edita a información da conta dun usuario
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/editarConta")
	public String editarConta(Model model) {
		String saida = "editarConta";
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();

		Usuario usuario = UsuarioServicio.getUsuario(name);
		model.addAttribute("usuario", usuario);

		return saida;
	}

	
	/**
	 * Edita a información dun usuario recibia polo formulario 
	 * @param usuario
	 * @param result
	 * @return String
	 */
	@RequestMapping(value = "/editarConta", method = RequestMethod.POST)
	public String updateUsuario(@Valid Usuario usuario, BindingResult result) {
		String saida = "";
		
		if (usuario.getTipousuario().equals(ConstantesUtil.ROLE_ADMIN)){
			
			if (result.hasErrors()) {
				return "editarConta";
			}
			UsuarioServicio.updateUsuario(usuario);
			saida = "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/admin/listaUsuarios";
			
		}else if (ConstantesUtil.ROLE_ARMADOR.equals(usuario.getTipousuario())){
			
			if (result.hasErrors()) {
				return "editarContaArmador";
			}
			UsuarioServicio.updateUsuario(usuario);
			
			saida = "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/armador";
		} else if(ConstantesUtil.ROLE_PATRON.equals(usuario.getTipousuario())){
			if (result.hasErrors()) {
				return "editarContaPatron";
			}
			UsuarioServicio.updateUsuario(usuario);
			
			saida = "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/patron";
			
		}
		
		return saida;
	}

}