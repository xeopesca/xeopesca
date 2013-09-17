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
public class BuscadorPescaController {
  
	    
	    
	 @RequestMapping("/patron/buscadorpesca")
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


	        return "buscadorPesca"; 
	    }
	 
	 @RequestMapping(value = "/patron/buscadorpesca", method = RequestMethod.POST)
	 	public String buscadorFaena(FaenaBuscador faenaB, Model model) {
	 		 		
	 		Faena faena = new Faena();
	 		faena= FaenaBuscador.convertFaenaBuscardorToFaena(faenaB);
	 		//Chamamos ao servicio para recuperar o resultado da busqueda
			List<Faena>  resultado = FaenaServicio.findBuscadorFaena(faena);
			
			//Recuperamos os datos do Patron
					Authentication auth = SecurityContextHolder.getContext().getAuthentication();
					String loginPatron = auth.getName();
					Usuario patron = UsuarioServicio.getUsuario(loginPatron);
			    	
			/*
	    	 * VALORES
	    	 * */
	    	model.addAttribute("artes", ArteServicio.listaDeArtes());
	    	model.addAttribute("especies", EspecieServicio.listaDeEspecies());
	        model.addAttribute("idbarco", patron.getIdbarco());
	        model.addAttribute("lua", ParametriaServicio.recuperarParametro("lua") );
	    	model.addAttribute("mar", ParametriaServicio.recuperarParametro("mar") );
	    	model.addAttribute("ceo", ParametriaServicio.recuperarParametro("ceo") );
	    	model.addAttribute("dirvento", ParametriaServicio.recuperarParametro("dir.vento") );
		
	    	model.addAttribute("faena",faenaB);
	       
	    
			
			
	        return "buscadorPesca"; 
	 	}
	    
	    
    
}


