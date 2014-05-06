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
import com.xeopesca.webapp.model.servicios.ArteServicio;
import com.xeopesca.webapp.model.vos.Arte;
import com.xeopesca.webapp.model.vos.Especie;

@Controller
public class ArteController {
	List<Especie> especies;

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}


		
	/**
	 * Formulario de entrada para una nova arte 
	 * @param model
	 * @param arte
	 * @return String
	 */
	@RequestMapping(value = "/admin/novoArte", method = RequestMethod.GET)
	public String novaArte(Model model, Arte arte) {
		model.addAttribute("arte", arte);
		return "novoArte";
	}

	/**
	 * Formulario de saida de nova arte e salva a informacion na base de datos
	 * @param arte
	 * @param result
	 * @return String
	 */
	@RequestMapping(value = "/admin/novoArte", method = RequestMethod.POST)
	public String novaArte(Arte arte, BindingResult result) {

		ArteServicio.saveArte(arte);

		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/admin/listaArte";

	}


	/**
	 * Recupera a lista das artes 
	 * @param model
	 * @return String
	 */
	@RequestMapping("/admin/listaArte")
	public String listaArtes(Model model) {
		model.addAttribute("artes", ArteServicio.listaDeArtes());
		return "listaArte";
	}

	
	/**
	 * Borrar unha arte por id
	 * @param id
	 * @return String
	 */
	@RequestMapping("/admin/deleteArte/{id}")
	public String borrarArte(@PathVariable("id") Long id) {
		ArteServicio.removeArte(id);

		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/admin/listaArte";
	}

	/**
	 * Entrada no Buscador dunha arte por nome
	 * @param model
	 * @param arte
	 * @return String
	 */
	@RequestMapping(value = "/admin/buscadorArte", method = RequestMethod.GET)
	public String buscadorArte(Model model, Arte arte) {
		model.addAttribute("arte", arte);
		return "buscadorArte";
	}

	/**
	 * Procesamento do buscador de arte por arte (POST)
	 * @param arte
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/admin/buscadorArte", method = RequestMethod.POST)
	public String buscadorUsuario(Arte arte, Model model) {
		List<Arte> lista = ArteServicio.buscarArte(arte.getNome());

		if (lista.isEmpty()) {
			model.addAttribute("mensaxe", "lista vacia");
		} else {
			model.addAttribute("artes", lista);
			model.addAttribute("mensaxe", "lista chea");
		}

		return "buscadorArte";
	}


	/**
	 * Entrada no formulario para edición dunha arte
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/admin/editarArte/{id}")
	public String editarUsuario(@PathVariable("id") Long id, Model model) {

		Arte arte = ArteServicio.buscarArte(id);
		model.addAttribute("arte", arte);
		return "editarArte";
	}

	/**
	 * Saida do formulario para edición dunha arte, salva os cambios na BD
	 * @param arte
	 * @param result
	 * @return String
	 */
	@RequestMapping(value = "/admin/editarArte", method = RequestMethod.POST)
	public String updateUsuario(@Valid Arte arte, BindingResult result) {
		if (result.hasErrors()) {
			return "editarArte";
		}

		ArteServicio.updateArte(arte);
		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/admin/listaArte";
	}

}