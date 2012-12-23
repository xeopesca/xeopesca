package com.xeopesca.webapp.controller.administrador;

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

import com.xeopesca.webapp.model.servicios.EspecieServicio;
import com.xeopesca.webapp.model.vos.Especie;

@Controller
public class EspecieController {
	List<Especie> especies;

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	// -------------------------- NOVA ESPECIE
	// -------------------------------------
	// ENTRADA FORMULARIO -- novaEspecie
	@RequestMapping(value = "/novaEspecie", method = RequestMethod.GET)
	public String novoEspecie(Model model, Especie especie) {
		model.addAttribute("especie", especie);
		return "novaEspecie";
	}

	// SAIDA FORMULARIO
	@RequestMapping(value = "/novaEspecie", method = RequestMethod.POST)
	public String novaEspecie(Especie especie, BindingResult result) {

		EspecieServicio.saveEspecie(especie);

		// UsuarioServicio.saveUsuario(usuario);
		return "redirect:/spring/listaEspecies";
	}

	// -------------------------- LISTADO ESPECIE
	// --------------------------------
	// ENTRADA LISTA USUARIOS
	@RequestMapping("/listaEspecies")
	public String listaUsuarios(Model model) {

		List<Especie> especies = new ArrayList<Especie>();
		especies = EspecieServicio.listaDeEspecies();

		model.addAttribute("especies", especies);

		return "listaEspecies";
	}

	// SAIDA FORMULARIO -- eliminar especie
	@RequestMapping("/deleteEspecie/{id}")
	public String borrarUsuario(@PathVariable("id") Long id) {

		EspecieServicio.removeEspecie(id);

		return "redirect:/spring/listaEspecies";
	}

	// -------------------------- Editar ESPECIE

	// Entrada Formulario editarEspecie
	@RequestMapping("/editarEspecie/{id}")
	public String editarEspecie(@PathVariable("id") Long id, Model model) {
		Especie especie = EspecieServicio.buscarEspecie(id);
		model.addAttribute("especie", especie);
		return "editarEspecie";
	}

	// SAIDA FORMULARIO editar Especie
	@RequestMapping(value = "/updateEspecie", method = RequestMethod.POST)
	public String editarEspecie(@Valid Especie especie, BindingResult result) {
		if (result.hasErrors()) {
			return "editarEspecie";
		}

		EspecieServicio.updateUsuario(especie);
		return "redirect:/spring/listaEspecies";
	}
	
	//------------------------ BUSCADOR ESPECIE
	
	// BUSCADOR buscadorEspecie - Entrada
		@RequestMapping(value = "/buscadorEspecie", method = RequestMethod.GET)
		public String buscadorEspecie(Model model, Especie especie) {
			model.addAttribute("mensaxe", "inicio");
			model.addAttribute("especie", especie);
			return "buscadorEspecie";
		}
		
		
		// SAIDA FORMULARIO BUSCADOR 
		@RequestMapping(value = "/buscadorEspecie", method = RequestMethod.POST)
		public String buscadorUsuario(Especie especie,Model model) {
			List<Especie> lista  = EspecieServicio.buscarEspecie(especie.getnomecientifico()) ;

			if (lista.isEmpty()){
				model.addAttribute("mensaxe", "lista vacia");
			}else{
				model.addAttribute("especies", lista);
				model.addAttribute("mensaxe", "lista chea");
			}	
			
			return "buscadorEspecie";
		}
		//--------------------------------------------------------------
		
	
}