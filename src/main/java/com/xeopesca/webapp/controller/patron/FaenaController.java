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
import com.xeopesca.util.HelperDateUtil;
import com.xeopesca.webapp.view.FaenaBuscador;
import com.xeopesca.webapp.model.servicios.ArteServicio;
import com.xeopesca.webapp.model.servicios.BarcoServicio;
import com.xeopesca.webapp.model.servicios.EspecieServicio;
import com.xeopesca.webapp.model.servicios.FaenaServicio;
import com.xeopesca.webapp.model.servicios.ParametriaServicio;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Barco;
import com.xeopesca.webapp.model.vos.Faena;
import com.xeopesca.webapp.model.vos.Parametria;
import com.xeopesca.webapp.model.vos.Usuario;


@Controller
public class FaenaController {
   
    
    /**
     * Formulario de entrada para dar de alta unha nova faena
     * @param model
     * @return plantilla tiles a cargar
     */
    @RequestMapping("/patron/novaFaena")
    public String novaFaena(Model model) {
    	FaenaBuscador faena = new FaenaBuscador();
    	//Faena faena = new Faena();
    	/*
    	 *  PARAMETRIA
    	 */
    	model.addAttribute("lua", ParametriaServicio.recuperarParametro("lua") );
    	model.addAttribute("mar", ParametriaServicio.recuperarParametro("mar") );
    	model.addAttribute("ceo", ParametriaServicio.recuperarParametro("ceo") );
    	model.addAttribute("dirvento", ParametriaServicio.recuperarParametro("dir.vento") );
    	model.addAttribute("artes", ArteServicio.listaDeArtes());
    	model.addAttribute("especies", EspecieServicio.listaDeEspecies());
    	
    	/*
    	 * Obxecto a parsear
    	 * */
    	
    	//Recuperamos os datos do Armador
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String patronLogin = auth.getName();
    	Usuario patron = UsuarioServicio.getUsuario(patronLogin);
    	
    	faena.setHoraFin(HelperDateUtil.TimeToString(new Date()));
    	faena.setHoraInicio("00:00");
    	faena.setDataInicio(HelperDateUtil.DateToString(new Date()));
    	faena.setDataFin(HelperDateUtil.DateToString(new Date()));
    	
		faena.setIdbarco(patron.getIdbarco());
    	model.addAttribute("faena",faena);
    	
    	
        return "novaFaena"; 
    }
    
 	/**
 	 * Formulario de saida para dar de alta unha faena
 	 * @param faena
 	 * @param result
 	 * @return plantilla tiles a cargar
 	 */
 	@RequestMapping(value = "/patron/novaFaena", method = RequestMethod.POST)
 	public String novaFaena(FaenaBuscador faena, BindingResult result) {
 		 		
 		Faena f = new Faena();
 		f.setIdarte(new Long (faena.getArte()));
 		
 		
 		//datainicio
 	 	f.setData_inicio(HelperDateUtil.StringToDate(faena.getDataInicio()));
 		//Data fin
 	 	f.setData_fin(HelperDateUtil.StringToDate(faena.getDataFin()));
 	 	//hora inicio
 		f.setHora_inicio(HelperDateUtil.StringToTime(faena.getHoraInicio()));
 		//hora fin
 		f.setHora_fin(HelperDateUtil.StringToTime(faena.getHoraFin()));
 		f.setLua(faena.getLua());
 		f.setTemp_aire(faena.getTempAire());
 		f.setTemp_superficie(faena.getTempSuperficie());
 		f.setTemp_fondo(faena.getTempFondo());
 		f.setEstado_mar(faena.getEstadoMar()); 
		f.setVelocidade_vento(faena.getVelocidadeVento());
		f.setDireccion_vento(faena.getDireccionVento());
		f.setIdbarco(faena.getIdbarco());
		f.setEstado_ceo(faena.getEstadoCeo());
 		FaenaServicio.saveFaena(f);

 		 		
 		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
 	}
    
 	
    
    /**
     * Formulario de entrada para buscar unha faena
     * @param model
     * @return plantilla tiles a cargar
     */
    @RequestMapping("/patron/buscadorFaena")
    public String buscadorFaena(Model model) {
    	//Recuperamos os datos do Patron
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginPatron = auth.getName();
		Usuario patron = UsuarioServicio.getUsuario(loginPatron);
    	
    	
    	//Faena faena = new Faena();
    	FaenaBuscador faenaB = new FaenaBuscador();
    	model.addAttribute("faena",faenaB);
    	
    	/*
    	 *  PARAMETRIA
    	 */
    	model.addAttribute("lua", ParametriaServicio.recuperarParametro("lua") );
    	model.addAttribute("mar", ParametriaServicio.recuperarParametro("mar") );
    	model.addAttribute("ceo", ParametriaServicio.recuperarParametro("ceo") );
    	model.addAttribute("dirvento", ParametriaServicio.recuperarParametro("dir.vento") );

    	 
    	/*
    	 * VALORES
    	 * */
    	model.addAttribute("artes", ArteServicio.listaDeArtes());
    	model.addAttribute("especies", EspecieServicio.listaDeEspecies());
        model.addAttribute("idbarco", patron.getIdbarco());


        return "buscadorFaena"; 
    }
    
  
	
    /**
     * Formulario de saida para buscar unha faena
     * @param faenaB
     * @param model
     * @return plantilla tiles a cargar
     */
    @RequestMapping(value = "/patron/buscadorFaena", method = RequestMethod.POST)
 	public String buscadorFaena(FaenaBuscador faenaB, Model model) {
 		 		
 		Faena faena = new Faena();
 		faena= FaenaBuscador.convertFaenaBuscardorToFaena(faenaB);
 		//Chamamos ao servicio para recuperar o resultado da busqueda
		List<Faena>  resultado = FaenaServicio.findBuscadorFaena(faena);
		
		//Recuperamos os datos do Patron
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				String loginPatron = auth.getName();
				Usuario patron = UsuarioServicio.getUsuario(loginPatron);
		    	
		
		
		//PREPARAMOS OS ELEMENTOS DE SAIDA
		model.addAttribute("resultado",resultado);
    	model.addAttribute("faena",faenaB);
        model.addAttribute("idbarco", patron.getIdbarco());

    	
    	/*
    	 *  PARAMETRIA e combos
    	 */
    	model.addAttribute("lua", ParametriaServicio.recuperarParametro("lua") );
    	model.addAttribute("mar", ParametriaServicio.recuperarParametro("mar") );
    	model.addAttribute("ceo", ParametriaServicio.recuperarParametro("ceo") );
    	model.addAttribute("dirvento", ParametriaServicio.recuperarParametro("dir.vento") );
    	model.addAttribute("artes", ArteServicio.listaDeArtes());
    	model.addAttribute("especies", EspecieServicio.listaDeEspecies());
    	
		
		
        return "buscadorFaena"; 
 	}
    
    
    
    
  
 	/**
 	 * Listado de faenas realizadas por un patrón
 	 * @param model
 	 * @return plantilla tiles a cargar
 	 */
 	@RequestMapping("/patron/listaFaena")
 	public String listaFaenas(Model model) {
 		
		//Recuperamos os datos do patron
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String patronLogin = auth.getName();
		Usuario patron = UsuarioServicio.getUsuario(patronLogin);
 		//
		List<Faena> faenasLista = FaenaServicio.faenasDunBarco(patron.getIdbarco());
		List<FaenaBuscador> faenas = FaenaBuscador.convertFaenaToListFaenaBuscardor(faenasLista);
 		//model.addAttribute("faenas", faenas);
 		model.addAttribute("faenas", faenasLista);
 		return "listaFaena";
 	}
 	

	/**
	 * Formulario de edición dunha faena
	 * @param idFaena
	 * @param model
	 * @return plantilla tiles a cargar
	 */
	@RequestMapping("/patron/editarFaena/{id}")
	public String editarFaena(@PathVariable("id") Long idFaena, Model model) {
		
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
    	
    	/*
    	 * VALORES
    	 * */
    	model.addAttribute("artes", ArteServicio.listaDeArtes());
    	model.addAttribute("especies", EspecieServicio.listaDeEspecies());
		
		Faena fae = FaenaServicio.findById(idFaena);
		FaenaBuscador faena = FaenaBuscador.convertFaenaToFaenaBuscardor(fae);
		
		if (fae.getIdbarco() == patron.getIdbarco()){
	 		model.addAttribute("faena", faena);
			return "editarFaena";
		}else{

			return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
		}
	}
	
	/**
	 * Formulario de procesamento da edición dunha faena
	 * @param faena
	 * @param result
	 * @return plantilla tiles a cargar
	 */
	@RequestMapping(value = "/patron/editarFaena", method = RequestMethod.POST)
	public String editarFaena(@Valid FaenaBuscador faena, BindingResult result) {
		Faena faenaVO = new Faena();
		
		if (result.hasErrors()) {
			return "editarFaena";
		}
		//Recuperamos os datos do patron
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String patronLogin = auth.getName();
		Usuario patron = UsuarioServicio.getUsuario(patronLogin);
		if (patron.getIdbarco()==faena.getIdbarco()){
			faenaVO  =  FaenaBuscador.convertFaenaBuscardorToFaena(faena);
			
			FaenaServicio.updateFaena(faenaVO);
			
		}
		
		
		
		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
	}
	
	/**
	 * Borrado dunha faena
	 * @param idFaena
	 * @param model
	 * @return plantilla tiles a cargar
	 */
	@RequestMapping("/patron/deleteFaena/{id}")
	public String borrarFaena(@PathVariable("id") Long idFaena, Model model) {
		//Recuperamos os datos do Patron
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginPatron = auth.getName();
		Usuario patron = UsuarioServicio.getUsuario(loginPatron);
		
		Faena fae = FaenaServicio.findById(idFaena);

		if (fae.getIdbarco() == patron.getIdbarco()){
	 		FaenaServicio.removeFaena(fae.getId());
			
		}
		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
	}
	
	
	
    
}