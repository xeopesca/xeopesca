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

import com.xeopesca.webapp.model.servicios.EspecieServicio;
import com.xeopesca.webapp.model.servicios.FaenaServicio;
import com.xeopesca.webapp.model.servicios.LanceServicio;
import com.xeopesca.webapp.model.servicios.PescaServicio;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;

import com.xeopesca.webapp.model.vos.Faena;
import com.xeopesca.webapp.model.vos.Lance;
import com.xeopesca.webapp.model.vos.Pesca;
import com.xeopesca.webapp.model.vos.Usuario;


@Controller
public class PescaController {
   
    
		@RequestMapping("/patron/addPesca/{id}")
		public String novaPesca(@PathVariable("id") Long idLance, Model model) {
			//Recuperamos os datos do Patron
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String loginPatron = auth.getName();
			Usuario patron = UsuarioServicio.getUsuario(loginPatron);
			//Recuperamos o lance asociado
			Lance lan = LanceServicio.findById(idLance);
			
			
			
			//Comprobamos que sexa correcto o acceso
			if (lan!=null && patron.getIdbarco() == lan.getFaena().getIdbarco()){
				Pesca pesca = new Pesca();
				pesca.setIdlance(lan.getId());
				model.addAttribute("pesca", pesca);
				model.addAttribute("especies", EspecieServicio.listaDeEspecies());
				return "addPesca";
			}
			else{
				return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
			}
			
		}
		
	@RequestMapping(value = "/patron/addPesca", method = RequestMethod.POST)
	public String engadirPesca(Pesca pesca, BindingResult result) {
		PescaServicio.createPesca(pesca);
		Pesca pescabd =PescaServicio.findById(pesca.getId());
		
		return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
				+ "/patron/novoLance/" + pescabd.getLance().getIdfaena();

	}
	
	@RequestMapping(value = "/patron/deletePesca", method = RequestMethod.POST)
	public String deletePesca(Pesca pesca, BindingResult result) {
		Pesca pescaBD = PescaServicio.findById(pesca);
		PescaServicio.removePesca(pesca);
		
		return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
				+ "/patron/novoLance/" + pescaBD.getLance().getIdfaena();

	}
	
	@RequestMapping("/patron/editarPesca/{id}")
	public String editarPesca(@PathVariable("id") Long id, Model model){
		//Recuperamos os datos do Patron
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginPatron = auth.getName();
		Usuario patron = UsuarioServicio.getUsuario(loginPatron);
		//Recuperamos os datos da pesca
		Pesca pesca = PescaServicio.findById(id);
		//Loxica
		if (pesca.getLance().getFaena().getIdbarco() == patron.getIdbarco()){
			model.addAttribute("pesca", pesca);
			model.addAttribute("especies", EspecieServicio.listaDeEspecies());

			return "editarPesca";
		}
		else{
			return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
		}
	
	}
	
	@RequestMapping(value = "/patron/updatePesca", method = RequestMethod.POST)
	public String updatePesca(Pesca pesca, BindingResult result) {
		
		PescaServicio.updatePesca(pesca);
		Pesca pescaBd = PescaServicio.findById(pesca.getId());
		
		return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
				+ "/patron/novoLance/" + pescaBd.getLance().getIdfaena();

	}
}