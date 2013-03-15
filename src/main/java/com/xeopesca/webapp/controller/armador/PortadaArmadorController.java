package com.xeopesca.webapp.controller.armador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vividsolutions.jts.geom.Geometry;

@Controller
public class PortadaArmadorController {
   
    
    @RequestMapping("/armador")
    public String helloWorld(Model model) {
    	
        model.addAttribute("message", "Hello World!");
        return "indexArmador"; 
    }
}