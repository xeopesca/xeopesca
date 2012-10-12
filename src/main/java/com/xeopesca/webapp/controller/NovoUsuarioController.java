package com.xeopesca.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xeopesca.webapp.model.vos.Usuario;

@Controller
public class NovoUsuarioController {

    @RequestMapping("/novoUsuario")
    public String helloWorld(Model model) {
    	Usuario user = new Usuario();
        model.addAttribute("message", "novousuario xxx funciona!!!");
        model.addAttribute("usuario",user );
        return "novoUsuario"; 
    }
    
    
}