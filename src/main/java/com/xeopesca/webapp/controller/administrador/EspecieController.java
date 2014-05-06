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


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.util.UploaderFileUtil;
import com.xeopesca.webapp.model.servicios.EspecieServicio;
import com.xeopesca.webapp.model.vos.Especie;

/**
 * @author belay
 *
 */

@Controller
public class EspecieController {
	private static final String PATH_IMAGES = "/var/lib/tomcat7/webapps/ROOT/images/especie/";
	//private static final String PATH_IMAGES= "/home/josecho/workspace/webapp/src/main/webapp/images/especie/";

	List<Especie> especies;

	@Autowired
	private Validator validator;
	private @Autowired
	HttpServletRequest request;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	
	/**
	 * Formulario para dar de alta unha nova especie (GET)
	 * @param model
	 * @param especie
	 * @return String
	 */
	@RequestMapping(value = "/admin/novaEspecie", method = RequestMethod.GET)
	public String novaEspecie(Model model, Especie especie) {
		model.addAttribute("especie", especie);
		return "novaEspecie";
	}

	
	/**
	 * Saida do formulario para gardar unha especie  (POST)
	 * @param especie
	 * @param result
	 * @param file
	 * @return String
	 */
	@RequestMapping(value = "/admin/novaEspecie", method = RequestMethod.POST)
	public String novaEspecie(@Valid Especie especie, BindingResult result,
			@RequestParam("file") MultipartFile file) {
		
		//Validacion erros
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.err.println("Error!!: " + error.getCode() + " - "
								+ error.getDefaultMessage());
				}
			return "novaEspecie";
		}

		String directorio = request.getSession().getServletContext().getRealPath("/");
		especie.setPath("/images/especie/");
		
		Especie especieOut = EspecieServicio.saveEspecie(especie);
		especie.setPath(especie.getPath()+especieOut.getId()+".jpg");
			
		if (UploaderFileUtil.uploadFile(file, PATH_IMAGES ,especie)){
			EspecieServicio.editarEspecie(especie);
			
			return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/admin/novoNomePopular/"+especieOut.getId();
		} 
		
		return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
				+ "/admin/novoNomePopular/";
		
	}

	
	/**
	 * Recupera todas as especies do sistema
	 * @param model
	 * @return String
	 */
	@RequestMapping("/admin/listaEspecies")
	public String listaEspecies(Model model) {

		List<Especie> especies = new ArrayList<Especie>();
		especies = EspecieServicio.listaDeEspecies();

		model.addAttribute("especies", especies);

		return "listaEspecies";
	}

	/**
	 * Borrar unha especie do sistema por id (GET)
	 * @param id
	 * @return String
	 */
	@RequestMapping("/admin/deleteEspecie/{id}")
	public String borrarEspecie(@PathVariable("id") Long id) {

		EspecieServicio.removeEspecie(id);

		return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
				+ "/admin/listaEspecies";
	}

	
	/**
	 * Formulario de entrada para a edición dunha especie (GET)
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/admin/editarEspecie/{id}")
	public String editarEspecie(@PathVariable("id") Long id, Model model) {
		Especie especie = EspecieServicio.buscarEspecie(id);
		model.addAttribute("especie", especie);
		return "editarEspecie";
	}

	/***
	 * SAIDA FORMULARIO editar Especie (POST)
	 * @param Especie
	 * @param BindingResult
	 * @param MultipartFile
	 * @return String
	 * */
	@RequestMapping(value = "/admin/updateEspecie", method = RequestMethod.POST)
	public String editarEspecie(@Valid Especie especie, BindingResult result,
			@RequestParam("file") MultipartFile file) {
		//Declaracion de variables
		String nomeFicheiro ="";
		
		//Validacion erros
		if (result.hasErrors()) {

			for (ObjectError error : result.getAllErrors()) {
				System.err.println("Error!!: " + error.getCode() + " - "
						+ error.getDefaultMessage());
			}
			return "editarEspecie";
		}
		
		if (UploaderFileUtil.uploadFile(file, PATH_IMAGES, especie)){
			especie.setPath("/images/especie/"+especie.getId()+".jpg");
			EspecieServicio.editarEspecie(especie);
			return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/admin/listaEspecies";
		} 
		else {
			return "editarEspecie";
		}

		
	}

	
	/**
	 * Formulario de entrada para buscar unha especie por nome (GET)
	 * @param model
	 * @param especie
	 * @return String
	 */
	@RequestMapping(value = "/admin/buscadorEspecie", method = RequestMethod.GET)
	public String buscadorEspecie(Model model, Especie especie) {
		model.addAttribute("mensaxe", "inicio");
		model.addAttribute("especie", especie);
		return "buscadorEspecie";
	}

	
	/**
	 * Formulario de saida para buscar unha especie  (POST)
	 * @param especie
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/admin/buscadorEspecie", method = RequestMethod.POST)
	public String buscadorUsuario(Especie especie, Model model) {
		List<Especie> lista = EspecieServicio.buscarEspecie(especie
				.getnomecientifico());

		if (lista.isEmpty()) {
			model.addAttribute("mensaxe", "lista vacia");
		} else {
			model.addAttribute("especies", lista);
			model.addAttribute("mensaxe", "lista chea");
		}

		return "buscadorEspecie";
	}

}