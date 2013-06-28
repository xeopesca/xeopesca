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