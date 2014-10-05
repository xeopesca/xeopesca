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
package com.xeopesca.webapp.controller.armador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;



import javax.validation.Valid;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Usuario;

/**
 * @author belay
 *
 */
@Controller
public class PatronController {
	List<Usuario> patrons;

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	
	/**
	 * Formulario de entrada para dar de alta un patrón
	 * @param model
	 * @param usuario
	 * @return plantilla tiles a cargar
	 */
	@RequestMapping(value = "/armador/novoPatron", method = RequestMethod.GET)
	public String novoPatron(Model model, Usuario usuario) {
		//Recuperamos os datos do Armador
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginArmador = auth.getName();
		Usuario armador = UsuarioServicio.getUsuario(loginArmador);
		model.addAttribute("usuario", usuario);
		return "novoPatron";
	}

	/**
	 * Formulario procesado para dar de alta un novo patrón
	 * @param patron
	 * @param result
	 * @return plantilla tiles a cargar
	 */
	@RequestMapping(value = "/armador/novoPatron", method = RequestMethod.POST)
	public String novoPatron(@Valid Usuario patron, BindingResult result) {
				
		if (result.hasErrors()) {
			return "novoPatron";
		}
		byte ap[] =patron.getApelidos().getBytes();
		try {
			patron.setApelidos(new String(ap,"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Recuperamos os datos do Armador
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginArmador = auth.getName();
		Usuario armador = UsuarioServicio.getUsuario(loginArmador);
		
		//Actualizamos os datos ao patr�n
		patron.setPatron_autoriza(armador.getId());
		UsuarioServicio.saveUsuario(patron);

		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/armador/listaPatron";
	}

	
	/**
	 * Lista de patróns dun armador
	 * @param model
	 * @return plantilla tiles a cargar
	 */
	@RequestMapping("/armador/listaPatron")
	public String listaPatronsDunArmador(Model model) {
		
		//Recuperamos os datos do Armador
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginArmador = auth.getName();
		Usuario armador = UsuarioServicio.getUsuario(loginArmador);
		
		//Damos de alta o patrón
		List<Usuario> patrons = new ArrayList<Usuario>();
		patrons = UsuarioServicio.buscarPatronsDunArmador(armador.getId());

		model.addAttribute("patrons", patrons);

		return "listaPatron";
	}
	
	
	/**
	 * Formulario de borrado de un patrón dun armador
	 * @param id
	 * @return plantilla tiles a cargar
	 */
	@RequestMapping("/armador/deletePatron/{id}")
	public String borradorPatronDunArmador(@PathVariable("id") Long id) {
		//Recuperamos os datos do Armador
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginArmador = auth.getName();
		Usuario armador = UsuarioServicio.getUsuario(loginArmador);

		UsuarioServicio.removePatron(id, armador.getId());

		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/armador/listaPatron";
	}


	/**
	 * Editar patrón dun armador
	 * @param id
	 * @param model
	 * @return plantilla tiles a cargar
	 */
	@RequestMapping("/armador/editarPatron/{id}")
	public String editarPatronDunArmador(@PathVariable("id") Long id, Model model) {
		 Usuario usuario;
		 usuario =  UsuarioServicio.buscarUsuario(id);
		
		model.addAttribute("usuario", usuario);
		return "editarPatron";
	}

	
	
	/**
	 * Formulario de entrada para a procura dun patron entre os que pertecen a un armador
	 * @param model
	 * @param usuario
	 * @return plantilla tiles a cargar
	 */
	@RequestMapping(value = "/armador/buscadorPatron", method = RequestMethod.GET)
	public String buscadorUsuario(Model model, Usuario usuario) {
			model.addAttribute("usuario", usuario);
			return "buscadorPatron";
	}	
	
	
	
	/**
	 * Buscador de patróns dun usuario
	 * @param patron
	 * @param model
	 * @return plantilla tiles a cargar
	 */
	@RequestMapping(value = "/armador/buscadorPatron", method = RequestMethod.POST)
	public String buscadorDePatronsDunUsuario(Usuario patron,Model model) {
			//Recuperamos os datos do Armador
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String loginArmador = auth.getName();
			Usuario armador = UsuarioServicio.getUsuario(loginArmador);
			
			
			List<Usuario> lista  = UsuarioServicio.buscarPatronsDunArmador(armador.getId(), patron.getLogin()) ;
					

			if (lista.isEmpty()){
				model.addAttribute("mensaxe", "Non hai resultados");
			}else{
				model.addAttribute("patrons", lista);
				model.addAttribute("mensaxe", "Hai resultados");
			}	
			
			return "buscadorPatron";
		}
	
	
}