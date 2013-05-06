package com.xeopesca.webapp.controller.patron;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
 		f.setIdbarco(9999);
 		f.setIdarte(new Long (faena.getArte()));
 		
 		Date data = null;
 		
 		//datainicio//datainicio
 		data = HelperDateUtil.StringToDate("10-05-2013");
 		if (data != null){
 	 		f.setData_inicio(data);
 		}
 		
 		//Data fin
 		f.setData_fin(data);
 		f.setHora_inicio(data);
 		f.setHora_fin(data);
 		
 		f.setLua(faena.getLua());
 		f.setTemp_aire(faena.getTempAire());
 		f.setTemp_superficie(faena.getTempSuperficie());
 		f.setTemp_fondo(faena.getTempFondo());
 		f.setEstado_mar(faena.getEstadoMar().toString()); //REVISAR
 		
 		
 		
 		FaenaServicio.saveFaena(f);
 		
 		
 		
 		
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