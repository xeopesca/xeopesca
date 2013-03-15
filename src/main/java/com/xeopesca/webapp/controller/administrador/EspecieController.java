package com.xeopesca.webapp.controller.administrador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.util.UploaderFileUtil;
import com.xeopesca.webapp.model.servicios.EspecieServicio;
import com.xeopesca.webapp.model.vos.Especie;

@Controller
public class EspecieController {
	List<Especie> especies;

	@Autowired
	private Validator validator;
	private @Autowired
	HttpServletRequest request;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	// -------------------------- NOVA ESPECIE
	// -------------------------------------
	// ENTRADA FORMULARIO -- novaEspecie
	@RequestMapping(value = "/admin/novaEspecie", method = RequestMethod.GET)
	public String novoEspecie(Model model, Especie especie) {
		model.addAttribute("especie", especie);
		return "novaEspecie";
	}

	// SAIDA FORMULARIO
	/**
	 * 
	 * */
	@RequestMapping(value = "/admin/novaEspecie", method = RequestMethod.POST)
	public String novaEspecie(Especie especie, BindingResult result,
			@RequestParam("file") MultipartFile file) {

		String direcotrio = request.getSession().getServletContext().getRealPath("/");
		EspecieServicio.saveEspecie(especie);

		if (UploaderFileUtil.uploadFile(file, especie, "./src/main/webapp/images/especie/")){
			especie.setPath("/images/especie/"+especie.getId()+".jpg");
			EspecieServicio.updateUsuario(especie);
			return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/admin/listaEspecies";
		} 
		
		return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
				+ "/admin/listaEspecies";
	}

	// -------------------------- LISTADO ESPECIE
	// --------------------------------
	// ENTRADA LISTA USUARIOS
	@RequestMapping("/admin/listaEspecies")
	public String listaUsuarios(Model model) {

		List<Especie> especies = new ArrayList<Especie>();
		especies = EspecieServicio.listaDeEspecies();

		model.addAttribute("especies", especies);

		return "listaEspecies";
	}

	// SAIDA FORMULARIO -- eliminar especie
	@RequestMapping("/admin/deleteEspecie/{id}")
	public String borrarUsuario(@PathVariable("id") Long id) {

		EspecieServicio.removeEspecie(id);

		return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
				+ "/admin/listaEspecies";
	}

	// -------------------------- Editar ESPECIE

	// Entrada Formulario editarEspecie
	@RequestMapping("/admin/editarEspecie/{id}")
	public String editarEspecie(@PathVariable("id") Long id, Model model) {
		Especie especie = EspecieServicio.buscarEspecie(id);
		model.addAttribute("especie", especie);
		return "editarEspecie";
	}

	/***
	 * SAIDA FORMULARIO editar Especie
	 * @param Especie
	 * @param BindingResult
	 * @param MultipartFile
	 * @return String
	 * */
	@RequestMapping(value = "/admin/updateEspecie", method = RequestMethod.POST)
	public String editarEspecie(@Valid Especie especie, BindingResult result,
			@RequestParam("file") MultipartFile file) {
		//Declaracion de variables
		String nomeFicheiro ="";
		
		//Validacion erros
		if (result.hasErrors()) {

			for (ObjectError error : result.getAllErrors()) {
				System.err.println("Error!!: " + error.getCode() + " - "
						+ error.getDefaultMessage());
			}
			return "editarEspecie";
		}
		
		if (UploaderFileUtil.uploadFile(file, especie, "./src/main/webapp/images/especie/")){
			especie.setPath("/images/especie/"+especie.getId()+".jpg");
			EspecieServicio.updateUsuario(especie);
			return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/admin/listaEspecies";
		} 
		else {
			return "editarEspecie";
		}

		
	}

	// ------------------------ BUSCADOR ESPECIE

	// BUSCADOR buscadorEspecie - Entrada
	@RequestMapping(value = "/admin/buscadorEspecie", method = RequestMethod.GET)
	public String buscadorEspecie(Model model, Especie especie) {
		model.addAttribute("mensaxe", "inicio");
		model.addAttribute("especie", especie);
		return "buscadorEspecie";
	}

	// SAIDA FORMULARIO BUSCADOR
	@RequestMapping(value = "/admin/buscadorEspecie", method = RequestMethod.POST)
	public String buscadorUsuario(Especie especie, Model model) {
		List<Especie> lista = EspecieServicio.buscarEspecie(especie
				.getnomecientifico());

		if (lista.isEmpty()) {
			model.addAttribute("mensaxe", "lista vacia");
		} else {
			model.addAttribute("especies", lista);
			model.addAttribute("mensaxe", "lista chea");
		}

		return "buscadorEspecie";
	}
	// --------------------------------------------------------------

}