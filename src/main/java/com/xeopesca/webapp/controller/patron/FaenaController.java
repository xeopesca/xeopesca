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
import com.xeopesca.webapp.model.servicios.ParametriaServicio;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Barco;
import com.xeopesca.webapp.model.vos.Faena;
import com.xeopesca.webapp.model.vos.Parametria;
import com.xeopesca.webapp.model.vos.Usuario;


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
    	model.addAttribute("dirvento", ParametriaServicio.recuperarParametro("dir.vento") );
    	model.addAttribute("artes", ArteServicio.listaDeArtes());
    	model.addAttribute("especies", EspecieServicio.listaDeEspecies());
    	
    	/*
    	 * Obxecto a parsear
    	 * */
    	
    	//Recuperamos os datos do Armador
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String patronLogin = auth.getName();
    	Usuario patron = UsuarioServicio.getUsuario(patronLogin);
    	
    	faena.setHoraFin(HelperDateUtil.TimeToString(new Date()));
    	faena.setHoraInicio("00:00");
    	faena.setDataInicio(HelperDateUtil.DateToString(new Date()));
    	faena.setDataFin(HelperDateUtil.DateToString(new Date()));
    	
		faena.setIdbarco(patron.getIdbarco());
    	model.addAttribute("faena",faena);
    	
    	
        return "novaFaena"; 
    }
    
 // SAIDA FORMULARIO
 	@RequestMapping(value = "/patron/novaFaena", method = RequestMethod.POST)
 	public String novaFaena(FaenaBuscador faena, BindingResult result) {
 		 		
 		Faena f = new Faena();
 		f.setIdarte(new Long (faena.getArte()));
 		
 		
 		//datainicio
 	 	f.setData_inicio(HelperDateUtil.StringToDate(faena.getDataInicio()));
 		//Data fin
 	 	f.setData_fin(HelperDateUtil.StringToDate(faena.getDataFin()));
 	 	//hora inicio
 		f.setHora_inicio(HelperDateUtil.StringToTime(faena.getHoraInicio()));
 		//hora fin
 		f.setHora_fin(HelperDateUtil.StringToTime(faena.getHoraFin()));
 		f.setLua(faena.getLua());
 		f.setTemp_aire(faena.getTempAire());
 		f.setTemp_superficie(faena.getTempSuperficie());
 		f.setTemp_fondo(faena.getTempFondo());
 		f.setEstado_mar(faena.getEstadoMar()); 
		f.setVelocidade_vento(faena.getVelocidadeVento());
		f.setDireccion_vento(faena.getDireccionVento());
		f.setIdbarco(faena.getIdbarco());
		f.setEstado_ceo(faena.getEstadoCeo());
 		FaenaServicio.saveFaena(f);

 		 		
 		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/";
 	}
    
 	
    
    @RequestMapping("/patron/buscadorFaena")
    public String buscadorFaena(Model model) {
    	//Faena faena = new Faena();
    	FaenaBuscador faenaB = new FaenaBuscador();
    	model.addAttribute("faena",faenaB);
    	
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
    	

        return "buscadorFaena"; 
    }
    
  
	
    @RequestMapping(value = "/patron/buscadorFaena", method = RequestMethod.POST)
 	public String buscadorFaena(FaenaBuscador faenaB, Model model) {
 		 		
 		Faena faena = new Faena();
 		faena= FaenaBuscador.convertFaenaBuscardorToFaena(faenaB);
 		//Chamamos ao servicio para recuperar o resultado da busqueda
		List<Faena>  resultado = FaenaServicio.findBuscadorFaena(faena);
		
		//PREPARAMOS OS ELEMENTOS DE SAIDA
		model.addAttribute("resultado",resultado);
    	model.addAttribute("faena",faenaB);
    	
    	/*
    	 *  PARAMETRIA e combos
    	 */
    	model.addAttribute("lua", ParametriaServicio.recuperarParametro("lua") );
    	model.addAttribute("mar", ParametriaServicio.recuperarParametro("mar") );
    	model.addAttribute("ceo", ParametriaServicio.recuperarParametro("ceo") );
    	model.addAttribute("dirvento", ParametriaServicio.recuperarParametro("dir.vento") );
    	model.addAttribute("artes", ArteServicio.listaDeArtes());
    	model.addAttribute("especies", EspecieServicio.listaDeEspecies());
    	
		
		
        return "buscadorFaena"; 
 	}
    
    
    
    
    /**
     * 	lista de faenas
     * 
     * */
    // ENTRADA de faenas
 	@RequestMapping("/patron/listaFaena")
 	public String listaFaenas(Model model) {
 		
		//Recuperamos os datos do patron
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String patronLogin = auth.getName();
		Usuario patron = UsuarioServicio.getUsuario(patronLogin);
 		//
		List<Faena> faenasLista = FaenaServicio.faenasDunBarco(patron.getIdbarco());
		List<FaenaBuscador> faenas = FaenaBuscador.convertFaenaToListFaenaBuscardor(faenasLista);
 		//model.addAttribute("faenas", faenas);
 		model.addAttribute("faenas", faenasLista);
 		return "listaFaena";
 	}
 	

	// Entrada Formulario editarFaena
	@RequestMapping("/patron/editarFaena/{id}")
	public String editarFaena(@PathVariable("id") Long idFaena, Model model) {
		
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
		
		if (fae.getIdbarco() == patron.getIdbarco()){
	 		model.addAttribute("faena", faena);
			return "editarFaena";
		}else{

			return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
		}
	}
	
	@RequestMapping(value = "/patron/editarFaena", method = RequestMethod.POST)
	public String editarFaena(@Valid FaenaBuscador faena, BindingResult result) {
		Faena faenaVO = new Faena();
		
		if (result.hasErrors()) {
			return "editarFaena";
		}
		//Recuperamos os datos do patron
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String patronLogin = auth.getName();
		Usuario patron = UsuarioServicio.getUsuario(patronLogin);
		if (patron.getIdbarco()==faena.getIdbarco()){
			faenaVO  =  FaenaBuscador.convertFaenaBuscardorToFaena(faena);
			FaenaServicio.saveFaena(faenaVO);
			
		}
		
		
		
		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
	}
	
	@RequestMapping("/patron/deleteFaena/{id}")
	public String borrarFaena(@PathVariable("id") Long idFaena, Model model) {
		//Recuperamos os datos do Patron
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginPatron = auth.getName();
		Usuario patron = UsuarioServicio.getUsuario(loginPatron);
		
		Faena fae = FaenaServicio.findById(idFaena);

		if (fae.getIdbarco() == patron.getIdbarco()){
	 		FaenaServicio.removeFaena(fae.getId());
			
		}
		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/patron/listaFaena";
	}
	
	
	
    
}