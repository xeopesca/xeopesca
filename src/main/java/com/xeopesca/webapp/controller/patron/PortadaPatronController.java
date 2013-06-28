package com.xeopesca.webapp.controller.patron;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Usuario;


@Controller
public class PortadaPatronController {
   
    
    @RequestMapping("/patron")
    public String portada(Model model) {
    	//Recuperamos os datos do Patron
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginPatron = auth.getName();
		Usuario patron = UsuarioServicio.getUsuario(loginPatron);
		
        model.addAttribute("message", "Hello World!");
        model.addAttribute("idbarco", patron.getIdbarco());
        return "indexPatron"; 
    }
}