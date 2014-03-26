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
package com.xeopesca.webapp.controller.patron;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.util.HelperDateUtil;
import com.xeopesca.webapp.view.FaenaBuscador;
import com.xeopesca.webapp.view.LanceView;
import com.xeopesca.webapp.model.servicios.ArteServicio;
import com.xeopesca.webapp.model.servicios.BarcoServicio;
import com.xeopesca.webapp.model.servicios.EspecieServicio;
import com.xeopesca.webapp.model.servicios.FaenaServicio;
import com.xeopesca.webapp.model.servicios.LanceServicio;
import com.xeopesca.webapp.model.servicios.ParametriaServicio;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Faena;
import com.xeopesca.webapp.model.vos.Lance;
import com.xeopesca.webapp.model.vos.Parametria;
import com.xeopesca.webapp.model.vos.Usuario;


/**
 * @author belay
 *
 */
@Controller
public class LanceController {
   
    
    
	/**
	 * Formulario para dar de alta un novo Lance
	 * @param idFaena
	 * @param model
	 * @return plantilla tiles a cargar
	 */
	@RequestMapping("/patron/novoLance/{id}")
	public String novoLance(@PathVariable("id") Long idFaena, Model model) {
		
		//Recuperamos os datos do Patron
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginPatron = auth.getName();
		Usuario patron = UsuarioServicio.getUsuario(loginPatron);
		/*
    	 *  PARAMETRIA
    	 */
    	model.addAttribute("lua", ParametriaServicio.recuperarParametro("lua") );
    	model.addAttribute("mar", ParametriaServicio.recuperarParametro("mar") );
    	model.addAttribute("ceo", ParametriaServicio.recuperarParametro("ceo") );
    	model.addAttribute("dirvento", ParametriaServicio.recuperarParametro("dir.vento") );
    	
    	/*    	 * VALORES
    	 * */
    	model.addAttribute("artes", ArteServicio.listaDeArtes());
    	model.addAttribute("especies", EspecieServicio.listaDeEspecies());
		
		Faena fae = FaenaServicio.findById(idFaena);
		
		//Est� intentando acceder a unha faena que non existe
		if (fae == null){
			return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
		}
		FaenaBuscador faena = FaenaBuscador.convertFaenaToFaenaBuscardor(fae);
		Lance lance = new  Lance();
		//Est� intentando acceder a unha faena que non lle pertence
		if (fae.getIdbarco() == patron.getIdbarco()){
	 		model.addAttribute("faena", faena);
	 		model.addAttribute("lances", fae.getListaLances());
	 		lance.setIdfaena(fae.getIdarte());
	 		
			return "novoLance";
		}else{

			return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
		}
	}
	
		/**
		 * Formulario polo que se agregar un novo lance
		 * @param idFaena
		 * @param model
		 * @return plantilla tiles a cargar
		 */
		@RequestMapping("/patron/addLance/{id}")
		public String addLance(@PathVariable("id") Long idFaena, Model model) {
			
			//Recuperamos os datos do Patron
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String loginPatron = auth.getName();
			Usuario patron = UsuarioServicio.getUsuario(loginPatron);
		
			Faena fae = FaenaServicio.findById(idFaena);
			FaenaBuscador faena = FaenaBuscador.convertFaenaToFaenaBuscardor(fae);
			//Lance lance = new  Lance();
			LanceView lance = new  LanceView();

			if (fae.getIdbarco() == patron.getIdbarco()){
		 		model.addAttribute("faena", faena);
		 		lance.setIdfaena(fae.getId());
		 	    model.addAttribute("id", fae.getId());
		 	    model.addAttribute("lance", lance);
				return "addLance";
			}else{

				return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
			}
		}
	
		/**
		 * @param lance
		 * @param result
		 * @return plantilla tiles a cargar
		 */
		@RequestMapping(value = "/patron/addLance", method = RequestMethod.POST)
	 	public String addLance(LanceView lance, BindingResult result) {
		
			Lance lanceBd = lance.convertToLance();
			
		LanceServicio.createLance(lanceBd);
			return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/novoLance/"+lance.getIdfaena();
			
		}
		
		/**
		 * Formulario co que se realiza o borrado dun lance
		 * @param lance
		 * @param result
		 * @return plantilla tiles a cargar
		 */
		@RequestMapping(value = "/patron/deleteLance", method = RequestMethod.POST)
	 	public String deleteLance(Lance lance, BindingResult result) {
		LanceServicio.removeLance(lance);
			return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/novoLance/"+lance.getIdfaena();
			
		}
		
		/**
		 * Formulario de edición dun novo lance
		 * @param id
		 * @param model
		 * @return plantilla tiles a cargar
		 */
		@RequestMapping("/patron/editarLance/{id}")
		public String editarLance(@PathVariable("id") Long id, Model model){
			//Recuperamos os datos do Patron
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String loginPatron = auth.getName();
			Usuario patron = UsuarioServicio.getUsuario(loginPatron);
			//Loxica
			Lance lance = LanceServicio.findById(id);
			if (lance !=null &&lance.getFaena().getIdbarco() == patron.getIdbarco()){
				model.addAttribute("lance", lance);

				return "editarLance";
			}
			else{
				return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
			}
			
			
		}
		
		/**
		 * Formulario polo que se procesa a edición dun lance
		 * @param lance
		 * @param result
		 * @return plantilla tiles a cargar
		 */
		@RequestMapping(value = "/patron/editarLance", method = RequestMethod.POST)
		public String editarLanceSaida(Lance lance, BindingResult result) {
			Lance lanceBd = LanceServicio.findById(lance.getId());
			lance.setListaPesca(lanceBd.getListaPesca());
			Lance lanceResposta = LanceServicio.updateLance(lance);
			long id = lanceResposta.getIdfaena();
			return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/novoLance/"+id;

		}
		
		   
}