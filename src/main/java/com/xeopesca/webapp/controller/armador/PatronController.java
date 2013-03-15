package com.xeopesca.webapp.controller.armador;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Usuario;

@Controller
public class PatronController {
	List<Usuario> patrons;

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	// -------------------------- NOVO Patron
	// -------------------------------------
	// ENTRADA FORMULARIO -- novoPatron
	@RequestMapping(value = "/armador/novoPatron", method = RequestMethod.GET)
	public String novoEspecie(Model model, Usuario usuario) {
		model.addAttribute("usuario", usuario);
		return "";
	}
/*
	// SAIDA FORMULARIO
	@RequestMapping(value = "/armador/novoPatron", method = RequestMethod.POST)
	public String novaEspecie(Usuario patron, BindingResult result) {
		
		UsuarioServicio.saveUsuario(patron);

		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/armador/listaBarco";
	}

	// -------------------------- LISTADO BARCOS
	// --------------------------------
	// ENTRADA LISTA BARCOS
	@RequestMapping("/armador/listaBarco")
	public String listaUsuarios(Model model) {

		List<Usuario> patrons = new ArrayList<Usuario>();
		patrons = BarcoServicio.listaDeBarcos();

		model.addAttribute("barcos", patrons);

		return "listaBarco";
	}

	// SAIDA FORMULARIO -- eliminar barco
	@RequestMapping("/armador/deletePatron/{id}")
	public String borrarUsuario(@PathVariable("id") Long id) {
		
		UsuarioServicio.removeUser(id);

		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/armador/listaBarco";
	}

	// -------------------------- Editar BARCO

	// Entrada Formulario editarEspecie
	@RequestMapping("/armador/editarPatron/{id}")
	public String editarEspecie(@PathVariable("id") Long id, Model model) {
		 Usuario usuario;
		 usuario =  UsuarioServicio.buscarUsuario(id);
		
		model.addAttribute("usuario", usuario);
		return "editarUsuario";
	}

	// SAIDA FORMULARIO editar Especie
	@RequestMapping(value = "/armador/editarPatron", method = RequestMethod.POST)
	public String editarEspecie(@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			return "editarBarco";
		}
		BarcoServicio.updateBarco(barco);
		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/armador/listaEspecies";
	}
	
	//------------------------ BUSCADOR ESPECIE
	
	// BUSCADOR buscadorEspecie - Entrada
		@RequestMapping(value = "/armador/buscadorBarco", method = RequestMethod.GET)
		public String buscadorEspecie(Model model, Especie especie) {
			model.addAttribute("mensaxe", "inicio");
			model.addAttribute("especie", especie);
			return "buscadorBarco";
		}
		
		
		// SAIDA FORMULARIO BUSCADOR 
		@RequestMapping(value = "/armador/buscadorBarco", method = RequestMethod.POST)
		public String buscadorUsuario(Especie especie,Model model) {
			List<Especie> lista  = EspecieServicio.buscarEspecie(especie.getnomecientifico()) ;

			if (lista.isEmpty()){
				model.addAttribute("mensaxe", "lista vacia");
			}else{
				model.addAttribute("especies", lista);
				model.addAttribute("mensaxe", "lista chea");
			}	
			
			return "buscadorBarco";
		}
	*/	
	
}