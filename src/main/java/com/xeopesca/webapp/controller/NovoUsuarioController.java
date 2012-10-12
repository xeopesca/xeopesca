package com.xeopesca.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NovoUsuarioController {

    @RequestMapping("/novoUsuario")
    public String helloWorld(Model model) {
        model.addAttribute("message", "novousuario xxx funciona!!!");
        return "novoUsuario"; 
    }
}