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

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vividsolutions.jts.geom.Geometry;
import com.xeopesca.webapp.model.servicios.BarcoServicio;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Barco;
import com.xeopesca.webapp.model.vos.Usuario;

@Controller
public class PortadaArmadorController {
   
    
    @RequestMapping("/armador")
    public String portada(Model model) {
    	
    	//Recuperamos os datos do Armador
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginArmador = auth.getName();
		Usuario armador = UsuarioServicio.getUsuario(loginArmador);
		
		
		List<Barco> barcos = new ArrayList<Barco>();
		barcos = BarcoServicio.listaDeBarcos(armador.getId());
		//Cadena de barcos
		String idBarcos ="";
		for (int i =0; i< barcos.size();i++){
			idBarcos = idBarcos + barcos.get(i).getId()+";";
		}

    	model.addAttribute("idbarcos", idBarcos);
    	
        return "indexArmador"; 
    }
}