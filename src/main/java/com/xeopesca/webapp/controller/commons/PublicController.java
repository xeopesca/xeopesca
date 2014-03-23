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
package com.xeopesca.webapp.controller.commons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.validation.Valid;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Usuario;

@Controller
public class PublicController {
	UsuarioServicio usuarioServ;
	List<Usuario> users;

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	


	@RequestMapping("/public/listaUsuarios")
	public String listaUsuarios(Model model) {

		users = UsuarioServicio.listaDeUsuarios();
		model.addAttribute("users", users);

		return "listaUsuarios";
	}

	@RequestMapping("/public/json")
	public ModelAndView json(Model model) {

		users = UsuarioServicio.listaDeUsuarios();
		model.addAttribute("users", users);
		ModelAndView re = new ModelAndView();
		re.setViewName("listaUsuarios");
		return re;
	}
	
	
	@RequestMapping("/public/json2")
	public String json2(Model model) {

		users = UsuarioServicio.listaDeUsuarios();
		model.addAttribute("users", users.toString());


		return "json";
	}
}