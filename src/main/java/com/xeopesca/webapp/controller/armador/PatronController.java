/* --------------------------------------------------------------------
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

@Controller
public class PatronController {
	List<Usuario> patrons;

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	// -------------------------- NOVO Patron
	// -------------------------------------
	// ENTRADA FORMULARIO -- novoPatron
	@RequestMapping(value = "/armador/novoPatron", method = RequestMethod.GET)
	public String novoPatron(Model model, Usuario usuario) {
		//Recuperamos os datos do Armador
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginArmador = auth.getName();
		Usuario armador = UsuarioServicio.getUsuario(loginArmador);
		
		
		
		
		model.addAttribute("usuario", usuario);

		return "novoPatron";
	}

	// SAIDA FORMULARIO
	@RequestMapping(value = "/armador/novoPatron", method = RequestMethod.POST)
	public String novoPatron(Usuario patron, BindingResult result) {
		patron.setTipousuario("ROLE_PATRON");
		//
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

	// -------------------------- LISTADO PATRONS ASOCIADOS A UN ARMADOR
	// --------------------------------
	// ENTRADA LISTA BARCOS
	@RequestMapping("/armador/listaPatron")
	public String listaUsuarios(Model model) {
		
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
	
	// SAIDA FORMULARIO -- eliminar patron
	@RequestMapping("/armador/deletePatron/{id}")
	public String borrarUsuario(@PathVariable("id") Long id) {
		//Recuperamos os datos do Armador
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginArmador = auth.getName();
		Usuario armador = UsuarioServicio.getUsuario(loginArmador);

		UsuarioServicio.removePatron(id, armador.getId());

		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/armador/listaPatron";
	}

	// -------------------------- Editar PATRON

	// Entrada 
	@RequestMapping("/armador/editarPatron/{id}")
	public String editarEspecie(@PathVariable("id") Long id, Model model) {
		 Usuario usuario;
		 usuario =  UsuarioServicio.buscarUsuario(id);
		
		model.addAttribute("usuario", usuario);
		return "editarPatron";
	}

	
	// BUSCADOR PATRON - Entrada
	@RequestMapping(value = "/armador/buscadorPatron", method = RequestMethod.GET)
	public String buscadorUsuario(Model model, Usuario usuario) {
			model.addAttribute("usuario", usuario);
			return "buscadorPatron";
	}	
	
	
	// SAIDA FORMULARIO BUSCADOR 
	@RequestMapping(value = "/armador/buscadorPatron", method = RequestMethod.POST)
	public String buscadorUsuario(Usuario patron,Model model) {
			//Recuperamos os datos do Armador
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String loginArmador = auth.getName();
			Usuario armador = UsuarioServicio.getUsuario(loginArmador);
			
			
			List<Usuario> lista  = UsuarioServicio.buscarPatronsDunArmador(armador.getId(), patron.getLogin()) ;
					

			if (lista.isEmpty()){
				model.addAttribute("mensaxe", "lista vacia");
			}else{
				model.addAttribute("patrons", lista);
				model.addAttribute("mensaxe", "lista chea");
			}	
			
			return "buscadorPatron";
		}
	
	
}