/* --------------------------------------------------------------------
 This file is part of xeoPesca

Copyright (C) 2013 - Pablo Belay FernÃ¡ndez 
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.webapp.model.servicios.FaenaServicio;
import com.xeopesca.webapp.model.servicios.LanceServicio;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Barco;
import com.xeopesca.webapp.model.vos.Faena;
import com.xeopesca.webapp.model.vos.Lance;
import com.xeopesca.webapp.model.vos.Usuario;

@Controller
public class PublicController {
	List<Usuario> users;

	@Autowired
	private Validator validator;
 
	public void setValidator(Validator validator) {
		this.validator = validator;
	}



	@RequestMapping("/public/test/json")
	public ModelAndView json(Model model) {
    //TODO In Spring 4 MappingJacksonJsonView is deprecated. 
	//TODO You might want to upgrade to MappingJackson2JsonView
		users = getVirtualUsers();
		model.addAttribute("users", users);
		model.addAttribute("outrosUsers", users);
		ModelAndView re = new ModelAndView();
		re.setViewName("listaUsuarios");
		re.setView(new MappingJacksonJsonView());
		return re;
	}
	
	
	@RequestMapping("/public/test/json2")
	public MappingJacksonJsonView json2(Model model) {
		users =getVirtualUsers();
		MappingJacksonJsonView mappingJson = new MappingJacksonJsonView();
		mappingJson.addStaticAttribute("osuusarios", users);
		mappingJson.addStaticAttribute("outrosUsuarios", users);
		return mappingJson;
	}
	
	
	@RequestMapping("/public/test/json3")
	public @ResponseBody List<Usuario> json3(Model model) {
		users = getVirtualUsers();
		return users;
	}
	
	



	@RequestMapping("/public/test/json4")
	public @ResponseBody Faena json4(Model model) {
		Faena f = new Faena();
		List<Lance> listaLances = new ArrayList();
		Lance  l = new Lance();
		Coordinate coordinate = new Coordinate(8, 45);
		PrecisionModel precisionModel = new PrecisionModel();
		     
		Point punto_fin = null;
		l.setPunto_fin(punto_fin );
		listaLances.add(l);
		f.setListaLances(listaLances );
		return f;
	}
	
	
	private List<Usuario> getVirtualUsers() {
		ArrayList<Usuario> lu = new ArrayList<Usuario> ();
		Usuario u1 = new  Usuario(1, new Barco(), "login", "nombre", "apellidos", "contraseña", "ROLE_USER");
		Usuario u2 = new  Usuario(2, new Barco(), "login2", "nombre2", "apellidos2", "contraseña2", "ROLE_USER");
		lu.add(u1);
		lu.add(u2);
		return lu;
	}

}