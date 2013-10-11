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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.validation.Valid;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Usuario;

@Controller
public class UsuarioController {
	UsuarioServicio usuarioServ;
	List<Usuario> users;

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	/**
	 * /admin/novoUsuario
	 * 
	 * @param model
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value = "/admin/novoUsuario", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String novoUsuario(Model model, Usuario usuario) {
		model.addAttribute("usuario", usuario);
		return "novoUsuario";
	}

	/**
	 * /admin/novoUsuario2
	 * 
	 * @param usuario
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/admin/novoUsuario2", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String novoUsuario(@Valid Usuario usuario, BindingResult result) {

		if (result.hasErrors()) {
			return "novoUsuario";
		}

		UsuarioServicio.saveUsuario(usuario);
		return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
				+ "/admin/listaUsuarios";
	}

	/**
	 * /admin/listaUsuarios
	 * 
	 * @param model
	 * @return String
	 */
	@RequestMapping("/admin/listaUsuarios")
	public String listaUsuarios(Model model) {

		users = UsuarioServicio.listaDeUsuarios();
		model.addAttribute("users", users);

		return "listaUsuarios";
	}

	/**
	 * /admin/delete/{id}
	 * 
	 * @param id
	 * @return String
	 */
	@RequestMapping("/admin/delete/{id}")
	public String borrarUsuario(@PathVariable("id") Long id) {

		UsuarioServicio.removeUser(id);

		return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
				+ "/admin/listaUsuarios";
	}

	/**
	 * /admin/buscadorUsuario
	 * 
	 * @param model
	 * @param usuario
	 * @return String plantilla tiles
	 */
	@RequestMapping(value = "/admin/buscadorUsuario", method = RequestMethod.GET)
	public String buscadorUsuario(Model model, Usuario usuario) {
		model.addAttribute("mensaxe", "inicio");
		model.addAttribute("usuario", usuario);
		return "buscadorUsuario";
	}

	/**
	 * /admin/buscadorUsuario
	 * 
	 * @param usuario
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/admin/buscadorUsuario", method = RequestMethod.POST)
	public String buscadorUsuario(Usuario usuario, Model model) {
		List<Usuario> lista = UsuarioServicio.buscarUsuarioSimilarLogin(usuario
				.getLogin());

		if (lista.isEmpty()) {
			model.addAttribute("mensaxe", "lista vacia");
		} else {
			model.addAttribute("users", lista);
			model.addAttribute("mensaxe", "lista chea");
		}

		return "buscadorUsuario";
	}

	/**
	 * /admin/editarUsuario/{id}
	 * 
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/admin/editarUsuario/{id}")
	public String editarUsuario(@PathVariable("id") Long id, Model model) {

		Usuario usuario = UsuarioServicio.buscarUsuario(id);
		model.addAttribute("usuario", usuario);
		return "editarUsuario";
	}

	/**
	 * /admin/updateUsuario
	 * @param usuario
	 * @param result
	 * @return String
	 */
	@RequestMapping(value = "/admin/updateUsuario", method = RequestMethod.POST)
	public String updateUsuario(@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			return "editarUsuario";
		}

		UsuarioServicio.updateUsuario(usuario);
		return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
				+ "/admin/listaUsuarios";
	}

}