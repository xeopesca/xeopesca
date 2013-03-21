package com.xeopesca.webapp.controller.patron;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PortadaPatronController {
   
    
    @RequestMapping("/patron")
    public String helloWorld(Model model) {
    	
        model.addAttribute("message", "Hello World!");
        return "indexPatron"; 
    }
}