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

import java.util.ArrayList;
import java.util.List;


import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.webapp.model.servicios.EspecieServicio;
import com.xeopesca.webapp.model.servicios.NomepopularServicio;
import com.xeopesca.webapp.model.vos.Especie;
import com.xeopesca.webapp.model.vos.Nomepopular;

/**
 * @author belay
 *
 */
/**
 * @author belay
 *
 */
@Controller
public class NomePopularController {

	@Autowired
	private Validator validator;
	public Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	
	/**
	 * @param model
	 * @param nomePopular
	 * @return
	 */
	@RequestMapping(value = "/admin/novoNomePopular", method = RequestMethod.GET)
	public String novaArte(Model model, Nomepopular nomePopular) {

		List<Especie> listaEspecie = EspecieServicio.listaDeEspecies();

		model.addAttribute("listaEspecie", listaEspecie);
		model.addAttribute("NomePopular", nomePopular);

		return "novoNomePopular";
	}

	/**
	 * @param nomePopular
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/admin/novoNomePopular", method = RequestMethod.POST)
	public String novaArte(Nomepopular nomePopular, BindingResult result) {

		NomepopularServicio.saveNomePopular(nomePopular);

		return "redirect:/xeopesca/admin/listaNomePopular";
	}

	// -------------------------- LISTADO de NOMES POPULARES
	// --------------------------------
	// ENTRADA LISTA DE NOMES POPULARES
	@RequestMapping("/admin/listaNomePopular")
	public String listaUsuarios(Model model) {

		List<Nomepopular> nomes = new ArrayList<Nomepopular>();
		nomes = NomepopularServicio.listaDeNomesPopulares();
		model.addAttribute("nomes", nomes);

		return "listaNomePopular";
	}

	// -------------------------- ELIMINAR NOME POPULAR
	@RequestMapping("/admin/deleteNomepopular/{id}")
	public String borrarUsuario(@PathVariable("id") Long id) {

		NomepopularServicio.removeNomePopular(id);

		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/admin/listaNomePopular";
	}

	// -------------------------- EDITAR NOME POPULAR
	@RequestMapping("/admin/editarNomePopular/{id}")
	public String editarEspecie(@PathVariable("id") Long id, Model model) {
		Nomepopular nome = NomepopularServicio.buscarNomepopular(id);
		List<Especie> listaEspecie = EspecieServicio.listaDeEspecies();

		model.addAttribute("listaEspecie", listaEspecie);
		model.addAttribute("nome", nome);
		return "editarNomePopular";
	}

	// SAIDA FORMULARIO editar Especie
	@RequestMapping(value = "/admin/editarNomePopular", method = RequestMethod.POST)
	public String editarEspecie(Nomepopular nomepopular, BindingResult result) {

		NomepopularServicio.updateNomepopularDao(nomepopular);

		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/admin/listaNomePopular";
	}

	
	//------------------------ BUSCADOR ESPECIE
	
		// BUSCADOR buscadorEspecie - Entrada
			@RequestMapping(value = "/admin/buscadorNomePopular", method = RequestMethod.GET)
			public String buscadorEspecie(Model model, Nomepopular nome) {
				model.addAttribute("nome", nome);
				return "buscadorNomePopular";
			}
			
			
			// SAIDA FORMULARIO BUSCADOR 
			@RequestMapping(value = "/admin/buscadorNomePopular", method = RequestMethod.POST)
			public String buscadorUsuario(Nomepopular nome,Model model) {
				List<Nomepopular> lista = NomepopularServicio.buscarNomePopular(nome.getNome());

				if (lista.isEmpty()){
					lista = new ArrayList<Nomepopular>();
					model.addAttribute("mensaxe", "lista vacia");
					model.addAttribute("nome",nome);
					model.addAttribute("nomes", lista);
				}else{
					model.addAttribute("nome",nome);
					model.addAttribute("nomes", lista);
					model.addAttribute("mensaxe", "lista chea");
				}	
				
				return "buscadorNomePopular";
			}
}