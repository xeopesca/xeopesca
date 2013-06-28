package com.xeopesca.webapp.controller.armador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.webapp.model.servicios.BarcoServicio;
import com.xeopesca.webapp.model.servicios.EspecieServicio;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Barco;
import com.xeopesca.webapp.model.vos.Especie;
import com.xeopesca.webapp.model.vos.Usuario;

@Controller
public class BarcoController {
	List<Barco> barcos;

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	// -------------------------- NOVO BARCO
	// -------------------------------------
	// ENTRADA FORMULARIO -- novoBarco
	@RequestMapping(value = "/armador/novoBarco", method = RequestMethod.GET)
	public String novoBarco(Model model, Barco barco) {
		
		//Recuperamos os datos do Armador
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginArmador = auth.getName();
		Usuario armador = UsuarioServicio.getUsuario(loginArmador);
				
		//Damos de alta o patr�n
		List<Usuario> patrons = new ArrayList<Usuario>();
		patrons = UsuarioServicio.buscarPatronsDunArmador(armador.getId());
		model.addAttribute("patrons", patrons);
		model.addAttribute("barco", barco);
		return "novoBarco";
	}

	// SAIDA FORMULARIO
	@RequestMapping(value = "/armador/novoBarco", method = RequestMethod.POST)
	public String novoBarco(Barco barco, BindingResult result) {
		//Recuperamos os datos do Armador
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginArmador = auth.getName();
		Usuario armador = UsuarioServicio.getUsuario(loginArmador);
		
		//Actualizamos os datos do barco
		barco.setIdarmador(armador.getId());
		BarcoServicio.saveBarco(barco);

		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/armador/listaBarco";
	}

	// -------------------------- LISTADO BARCOS
	// --------------------------------
	// ENTRADA LISTA BARCOS
	@RequestMapping("/armador/listaBarco")
	public String listaUsuarios(Model model) {
		
		//Recuperamos os datos do Armador
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginArmador = auth.getName();
		Usuario armador = UsuarioServicio.getUsuario(loginArmador);
		
		
		List<Barco> barcos = new ArrayList<Barco>();
		barcos = BarcoServicio.listaDeBarcos(armador.getId());

		model.addAttribute("barcos", barcos);
	
		return "listaBarco";
	}

	// SAIDA FORMULARIO -- eliminar barco
	@RequestMapping("/armador/deleteBarco/{id}")
	public String borrarUsuario(@PathVariable("id") Long id) {
		
		//Recuperamos os datos do Armador
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginArmador = auth.getName();
		Usuario armador = UsuarioServicio.getUsuario(loginArmador);
		List<Barco> lista = BarcoServicio.buscarBarcoArmador(id,armador.getId());
		
		if (lista.size()==0){
			return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/armador/listaBarco";
		}
		else {
			BarcoServicio.removeBarco(id);
		}
		
		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/armador/listaBarco";
	}

	// -------------------------- Editar BARCO

	// Entrada Formulario editarBarco
	@RequestMapping("/armador/editarBarco/{id}")
	public String editarBarco(@PathVariable("id") Long idBarco, Model model) {
		 Barco barco;
		//Recuperamos os datos do Armador
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loginArmador = auth.getName();
		Usuario armador = UsuarioServicio.getUsuario(loginArmador);
		//buscamos os patrons 
		List<Usuario> patrons = new ArrayList<Usuario>();
		patrons = UsuarioServicio.buscarPatronsDunArmador(armador.getId());
		 
		 List<Barco> lista = BarcoServicio.buscarBarcoArmador(idBarco,armador.getId());
		 if (lista.isEmpty()){
			 return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/armador/listaBarco";
		 }
		 else{
			 barco = lista.get(0);
		 }
		model.addAttribute("barco", barco);
		model.addAttribute("patrons", patrons);
		return "editarBarco";
	}
	
	
	
	private void porNuloBarcoPatronRelacionPaso1(Barco b1){
		if (b1 != null){
			
			
			if(b1.getIdpatron()!=null){
				Usuario p1 = UsuarioServicio.buscarUsuario(b1.getIdpatron());
				p1.setIdbarco(null);	
				UsuarioServicio.updateUsuario(p1);
			}
			b1.setIdpatron(null);
			BarcoServicio.updateBarco(b1);
		}
		
		
		
	}
	
	
	private void porNuloBarcoPatronRelacionPaso2(Usuario p1){
		if (p1 != null){
			
			
			if (p1.getIdbarco()!=null){
				Barco b1 = BarcoServicio.findByID(p1.getIdbarco());
				if (b1!=null){
					b1.setIdpatron(null);
					BarcoServicio.updateBarco(b1);
				}
				
			}
			
			p1.setIdbarco(null);	
			UsuarioServicio.updateUsuario(p1);
		}
		
	}

	// SAIDA FORMULARIO editar Barco
	@RequestMapping(value = "/armador/editarBarco", method = RequestMethod.POST)
	public String editarBarco(@Valid Barco barcoNew, BindingResult result) {
		if (result.hasErrors()) {
			return "editarBarco";
		}
		
		porNuloBarcoPatronRelacionPaso1( BarcoServicio.findByID(barcoNew.getId()));
		porNuloBarcoPatronRelacionPaso2 (UsuarioServicio.buscarUsuario(barcoNew.getIdpatron()));
		
		//Asignacion
		Usuario patronNew = UsuarioServicio.buscarUsuario(barcoNew.getIdpatron());
		
		if (barcoNew.getIdpatron()!=null){
			patronNew.setIdbarco(barcoNew.getId());
			UsuarioServicio.updateUsuario(patronNew);
		}
		
		BarcoServicio.updateBarco(barcoNew);
		
		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/armador/listaBarco";
	}
	
	//------------------------ BUSCADOR ESPECIE
	
	// BUSCADOR buscadorEspecie - Entrada
		@RequestMapping(value = "/armador/buscadorBarco", method = RequestMethod.GET)
		public String buscadorBarco(Model model, Barco barco) {
			model.addAttribute("mensaxe", "inicio");
			model.addAttribute("barco", barco);
			return "buscadorBarco";
		}
		
		
		// SAIDA FORMULARIO BUSCADOR 
		@RequestMapping(value = "/armador/buscadorBarco", method = RequestMethod.POST)
		public String buscadorBarcoResposta(Barco barco,Model model) {
			//Recuperamos os datos do Armador
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String loginArmador = auth.getName();
			Usuario armador = UsuarioServicio.getUsuario(loginArmador);
			
			List<Barco> lista  = BarcoServicio.buscarBarco(barco.getNome(),armador.getId());

			if (lista.isEmpty()){
				model.addAttribute("mensaxe", "lista vacia");
			}else{
				model.addAttribute("barcos", lista);
				model.addAttribute("mensaxe", "lista chea");
			}	
			
			return "buscadorBarco";
		}
		
	
}