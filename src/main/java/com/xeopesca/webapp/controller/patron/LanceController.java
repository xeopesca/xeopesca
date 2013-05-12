package com.xeopesca.webapp.controller.patron;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.util.HelperDateUtil;
import com.xeopesca.webapp.view.FaenaBuscador;
import com.xeopesca.webapp.model.servicios.ArteServicio;
import com.xeopesca.webapp.model.servicios.BarcoServicio;
import com.xeopesca.webapp.model.servicios.EspecieServicio;
import com.xeopesca.webapp.model.servicios.FaenaServicio;
import com.xeopesca.webapp.model.servicios.LanceServicio;
import com.xeopesca.webapp.model.servicios.ParametriaServicio;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Barco;
import com.xeopesca.webapp.model.vos.Faena;
import com.xeopesca.webapp.model.vos.Lance;
import com.xeopesca.webapp.model.vos.Parametria;
import com.xeopesca.webapp.model.vos.Usuario;


@Controller
public class LanceController {
   
    
    
	// Entrada Formulario editarBarco
	@RequestMapping("/patron/novoLance/{id}")
	public String novoLance(@PathVariable("id") Long idFaena, Model model) {
		
		//Recuperamos os datos do Patron
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginPatron = auth.getName();
		Usuario patron = UsuarioServicio.getUsuario(loginPatron);
		/*
    	 *  PARAMETRIA
    	 */
    	model.addAttribute("lua", ParametriaServicio.recuperarParametro("lua") );
    	model.addAttribute("mar", ParametriaServicio.recuperarParametro("mar") );
    	model.addAttribute("ceo", ParametriaServicio.recuperarParametro("ceo") );
    	model.addAttribute("dirvento", ParametriaServicio.recuperarParametro("dir.vento") );
    	
    	/*
    	 * VALORES
    	 * */
    	model.addAttribute("artes", ArteServicio.listaDeArtes());
    	model.addAttribute("especies", EspecieServicio.listaDeEspecies());
		
		Faena fae = FaenaServicio.findById(idFaena);
		FaenaBuscador faena = FaenaBuscador.convertFaenaToFaenaBuscardor(fae);
		Lance lance = new  Lance();
		if (fae.getIdbarco() == patron.getIdbarco()){
	 		model.addAttribute("faena", faena);
	 		model.addAttribute("lances", fae.getListaLances());
	 		lance.setIdfaena(fae.getIdarte());
	 		
			return "novoLance";
		}else{

			return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
		}
	}
	
	// Entrada Formulario editarBarco
		@RequestMapping("/patron/addLance/{id}")
		public String addLance(@PathVariable("id") Long idFaena, Model model) {
			
			//Recuperamos os datos do Patron
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String loginPatron = auth.getName();
			Usuario patron = UsuarioServicio.getUsuario(loginPatron);
		
			Faena fae = FaenaServicio.findById(idFaena);
			FaenaBuscador faena = FaenaBuscador.convertFaenaToFaenaBuscardor(fae);
			Lance lance = new  Lance();
			if (fae.getIdbarco() == patron.getIdbarco()){
		 		model.addAttribute("faena", faena);
		 		lance.setIdfaena(fae.getId());
		 	    model.addAttribute("id", fae.getId());
		 	    model.addAttribute("lance", lance);
				return "addLance";
			}else{

				return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
			}
		}
	
		@RequestMapping(value = "/patron/addLance", method = RequestMethod.POST)
	 	public String addLance(Lance lance, BindingResult result) {
			
			
		LanceServicio.createLance(lance);
			return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/novoLance/"+lance.getIdfaena();
			
		}
		
		@RequestMapping(value = "/patron/deleteLance", method = RequestMethod.POST)
	 	public String deleteLance(Lance lance, BindingResult result) {
		LanceServicio.removeLance(lance);
			return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/novoLance/"+lance.getIdfaena();
			
		}
		
		   
}