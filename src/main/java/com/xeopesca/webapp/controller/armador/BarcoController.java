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

import com.xeopesca.webapp.model.servicios.BarcoServicio;
import com.xeopesca.webapp.model.servicios.EspecieServicio;
import com.xeopesca.webapp.model.vos.Barco;
import com.xeopesca.webapp.model.vos.Especie;

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
	@RequestMapping(value = "/novoBarco", method = RequestMethod.GET)
	public String novoEspecie(Model model, Barco barco) {
		model.addAttribute("barco", barco);
		return "novoBarco";
	}

	// SAIDA FORMULARIO
	@RequestMapping(value = "/novoBarco", method = RequestMethod.POST)
	public String novaEspecie(Barco barco, BindingResult result) {
		BarcoServicio.saveBarco(barco);

		return "redirect:/spring/listaBarco";
	}

	// -------------------------- LISTADO BARCOS
	// --------------------------------
	// ENTRADA LISTA BARCOS
	@RequestMapping("/listaBarco")
	public String listaUsuarios(Model model) {

		List<Barco> barcos = new ArrayList<Barco>();
		barcos = BarcoServicio.listaDeBarcos();

		model.addAttribute("barcos", barcos);

		return "listaBarco";
	}

	// SAIDA FORMULARIO -- eliminar barco
	@RequestMapping("/deleteBarco/{id}")
	public String borrarUsuario(@PathVariable("id") String folio) {
		
		BarcoServicio.removeBarco(folio);

		return "redirect:/spring/listaBarco";
	}

	// -------------------------- Editar BARCO

	// Entrada Formulario editarEspecie
	@RequestMapping("/editarBarco/{id}")
	public String editarEspecie(@PathVariable("id") String folio, Model model) {
		 Barco barco;
		 List<Barco> lista = BarcoServicio.buscarBarco(folio);
		 if (lista.isEmpty()){
			 barco = new Barco();
		 }
		 else{
			 barco = lista.get(0);
		 }
		model.addAttribute("barco", barco);
		return "editarEspecie";
	}

	// SAIDA FORMULARIO editar Especie
	@RequestMapping(value = "/editarBarco", method = RequestMethod.POST)
	public String editarEspecie(@Valid Barco barco, BindingResult result) {
		if (result.hasErrors()) {
			return "editarBarco";
		}
		BarcoServicio.updateBarco(barco);
		return "redirect:/spring/listaEspecies";
	}
	
	//------------------------ BUSCADOR ESPECIE
	
	// BUSCADOR buscadorEspecie - Entrada
		@RequestMapping(value = "/buscadorBarco", method = RequestMethod.GET)
		public String buscadorEspecie(Model model, Especie especie) {
			model.addAttribute("mensaxe", "inicio");
			model.addAttribute("especie", especie);
			return "buscadorBarco";
		}
		
		
		// SAIDA FORMULARIO BUSCADOR 
		@RequestMapping(value = "/buscadorBarco", method = RequestMethod.POST)
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
		//--------------------------------------------------------------
		
	
}