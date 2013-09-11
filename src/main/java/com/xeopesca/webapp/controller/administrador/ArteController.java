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

	// -------------------------- NOVA ARTE
	// -------------------------------------
	// ENTRADA FORMULARIO -- novaArte
	@RequestMapping(value = "/admin/novoArte", method = RequestMethod.GET)
	public String novaArte(Model model, Arte arte) {
		model.addAttribute("arte", arte);
		return "novoArte";
	}

	// SAIDA FORMULARIO
	@RequestMapping(value = "/admin/novoArte", method = RequestMethod.POST)
	public String novaArte(Arte arte, BindingResult result) {

		ArteServicio.saveArte(arte);

		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/admin/listaArte";

	}

	// ENTRADA LISTA ARTES
	@RequestMapping("/admin/listaArte")
	public String listaUsuarios(Model model) {
		model.addAttribute("artes", ArteServicio.listaDeArtes());
		return "listaArte";
	}

	// SAIDA Eliminar Arte
	@RequestMapping("/admin/deleteArte/{id}")
	public String borrarUsuario(@PathVariable("id") Long id) {
		ArteServicio.removeArte(id);

		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/admin/listaArte";
	}

	// BUSCADOR USUARIO - Entrada
	@RequestMapping(value = "/admin/buscadorArte", method = RequestMethod.GET)
	public String buscadorUsuario(Model model, Arte arte) {
		model.addAttribute("mensaxe", "inicio");
		model.addAttribute("arte", arte);
		return "buscadorArte";
	}

	// SAIDA FORMULARIO BUSCADOR
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

	// EditarArte

	@RequestMapping("/admin/editarArte/{id}")
	public String editarUsuario(@PathVariable("id") Long id, Model model) {

		Arte arte = ArteServicio.buscarArte(id);
		model.addAttribute("arte", arte);
		return "editarArte";
	}

	// SAIDA FORMULARIO
	@RequestMapping(value = "/admin/editarArte", method = RequestMethod.POST)
	public String updateUsuario(@Valid Arte arte, BindingResult result) {
		if (result.hasErrors()) {
			return "editarArte";
		}

		ArteServicio.updateArte(arte);
		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/admin/listaArte";
	}

}