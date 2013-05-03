package com.xeopesca.webapp.controller.patron;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.webapp.view.FaenaBuscador;
import com.xeopesca.webapp.model.servicios.ArteServicio;
import com.xeopesca.webapp.model.servicios.BarcoServicio;
import com.xeopesca.webapp.model.servicios.EspecieServicio;
import com.xeopesca.webapp.model.servicios.FaenaServicio;
import com.xeopesca.webapp.model.servicios.ParametriaServicio;
import com.xeopesca.webapp.model.vos.Barco;
import com.xeopesca.webapp.model.vos.Faena;


@Controller
public class FaenaController {
   
    
    @RequestMapping("/patron/novaFaena")
    public String novaFaena(Model model) {
    	FaenaBuscador faena = new FaenaBuscador();
    	//Faena faena = new Faena();
    	/*
    	 *  PARAMETRIA
    	 */
    	model.addAttribute("lua", ParametriaServicio.recuperarParametro("lua") );
    	model.addAttribute("mar", ParametriaServicio.recuperarParametro("mar") );
    	model.addAttribute("ceo", ParametriaServicio.recuperarParametro("ceo") );
    	model.addAttribute("dir.vento", ParametriaServicio.recuperarParametro("dir.vento") );

    	
    	model.addAttribute("faena",faena);
    	model.addAttribute("artes", ArteServicio.listaDeArtes());
    	model.addAttribute("especies", EspecieServicio.listaDeEspecies());
    	
        return "novaFaena"; 
    }
    
 // SAIDA FORMULARIO
 	@RequestMapping(value = "/patron/novaFaena", method = RequestMethod.POST)
 	public String novaEspecie(FaenaBuscador faena, BindingResult result) {
 		 		
 		Faena f = new Faena();
 		f.setIdarte(new Long (faena.getArte()));
 		//datainicio
 		//horainicio
 		//datafin
 		//horafin
 		f.setLua(faena.getLua());
 		f.setTemp_aire(faena.getTempAire());
 		f.setTemp_superficie(faena.getTempSuperficie());
 		f.setTemp_fondo(faena.getTempFondo());
 		f.setEstado_mar(faena.getEstadoMar().toString()); //REVISAR
 		
 		
 		
 		FaenaServicio.saveFaena(f);
 		
 		
 		
 		int x;
 		x=0;
 		//BarcoServicio.saveBarco(barco);
 		
 		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/";
 	}
    
    
    
    @RequestMapping("/patron/buscadorFaena")
    public String buscadorFaena(Model model) {
    	Faena faena = new Faena();

    	model.addAttribute("faena",faena);
    	
    	/*
    	 *  PARAMETRIA
    	 */
    	model.addAttribute("lua", ParametriaServicio.recuperarParametro("lua") );
    	model.addAttribute("mar", ParametriaServicio.recuperarParametro("mar") );
    	model.addAttribute("ceo", ParametriaServicio.recuperarParametro("ceo") );
    	model.addAttribute("dir.vento", ParametriaServicio.recuperarParametro("dir.vento") );

    	 
    	/*
    	 * VALORES
    	 * */
    	model.addAttribute("artes", ArteServicio.listaDeArtes());
    	model.addAttribute("especies", EspecieServicio.listaDeEspecies());
    	
    	

        return "buscadorFaena"; 
    }
}