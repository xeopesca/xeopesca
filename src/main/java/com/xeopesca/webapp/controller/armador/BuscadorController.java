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
public class BuscadorController {
   
	  @RequestMapping("/armador/buscador")
	    public String buscadorFaena(Model model) {
	    	//Faena faena = new Faena();
	    	FaenaBuscador faenaB = new FaenaBuscador();
	    	model.addAttribute("faena",faenaB);
	    	
	    	//--
	    	//Recuperamos os datos do Armador e os barcos asociados
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String loginArmador = auth.getName();
			Usuario armador = UsuarioServicio.getUsuario(loginArmador);
			
			
			List<Barco> barcos = new ArrayList<Barco>();
			barcos = BarcoServicio.listaDeBarcos(armador.getId());

	    	
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
			model.addAttribute("barcos", barcos);


	        return "buscadorArmador"; 
	    }

	  
	 
		
	    @RequestMapping(value = "/armador/buscador", method = RequestMethod.POST)
	 	public String buscadorPost(FaenaBuscador faenaB, Model model) {
	 		Faena faena = new Faena();
	 		String idBarcosArmador ="";
	 		//Recuperamos os datos do Armador e os barcos asociados
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String loginArmador = auth.getName();
			Usuario armador = UsuarioServicio.getUsuario(loginArmador);
			List<Barco> barcos = new ArrayList<Barco>();
			barcos = BarcoServicio.listaDeBarcos(armador.getId());
			if (barcos!=null){
				for (int i=0; i< barcos.size(); i++){
					idBarcosArmador = idBarcosArmador+Long.toString(barcos.get(0).getId())+";";					
				}
			}
	 		faena= FaenaBuscador.convertFaenaBuscardorToFaena(faenaB);
	 		//Chamamos ao servicio para recuperar o resultado da busqueda
			List<Faena>  resultado = FaenaServicio.findBuscadorFaena(faena,idBarcosArmador);
			
			
			//PREPARAMOS OS ELEMENTOS DE SAIDA
			model.addAttribute("resultado",resultado);
			model.addAttribute("resultado2",resultado);

	    	model.addAttribute("faena",faenaB);
	    	model.addAttribute("barcos",barcos);

	    	/*
	    	 *  PARAMETRIA e combos
	    	 */
	    	model.addAttribute("lua", ParametriaServicio.recuperarParametro("lua") );
	    	model.addAttribute("mar", ParametriaServicio.recuperarParametro("mar") );
	    	model.addAttribute("ceo", ParametriaServicio.recuperarParametro("ceo") );
	    	model.addAttribute("dirvento", ParametriaServicio.recuperarParametro("dir.vento") );
	    	model.addAttribute("artes", ArteServicio.listaDeArtes());
	    	model.addAttribute("especies", EspecieServicio.listaDeEspecies());
	    	
			
			
	        return "buscadorArmador"; 
	 	}
	    
	    
	    
    
}


