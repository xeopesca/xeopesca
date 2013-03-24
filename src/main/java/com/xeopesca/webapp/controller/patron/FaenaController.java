package com.xeopesca.webapp.controller.patron;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.webapp.model.servicios.BarcoServicio;
import com.xeopesca.webapp.model.vos.Barco;
import com.xeopesca.webapp.model.vos.Faena;


@Controller
public class FaenaController {
   
    
    @RequestMapping("/patron/novaFaena")
    public String novaFaena(Model model) {
    	Faena faena = new Faena();
    	model.addAttribute("faena",faena);
        return "novaFaena"; 
    }
    
 // SAIDA FORMULARIO
 	@RequestMapping(value = "/patron/novaFaena", method = RequestMethod.POST)
 	public String novaEspecie(Faena faena, BindingResult result) {
 		//
 		//BarcoServicio.saveBarco(barco);

 		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/armador/listaBarco";
 	}
    
    
    
    @RequestMapping("/patron/buscadorFaena")
    public String buscadorFaena(Model model) {
    	
        return "buscadorFaena"; 
    }
}