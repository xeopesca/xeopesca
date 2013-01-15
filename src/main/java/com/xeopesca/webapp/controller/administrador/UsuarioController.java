package com.xeopesca.webapp.controller.administrador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import javax.validation.Valid;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Usuario;

@Controller
public class UsuarioController {
	UsuarioServicio usuarioServ;
	List<Usuario> users;

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	
	
	// ENTRADA FORMULARIO  -- NovoUsuario
	@RequestMapping(value = "/admin/novoUsuario", method = RequestMethod.GET)
	public String novoUsuario(Model model, Usuario usuario) {
		model.addAttribute("usuario", usuario);
		return "novoUsuario";
	}

	// SAIDA FORMULARIO
	@RequestMapping(value = "/admin/novoUsuario2", method = RequestMethod.POST)
	public String novoUsuario(@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			return "novoUsuario";
		}

		UsuarioServicio.saveUsuario(usuario);
		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/admin/listaUsuarios";
	}

	// ENTRADA LISTA USUARIOS
	@RequestMapping("/admin/listaUsuarios")
	public String listaUsuarios(Model model) {		

		users = UsuarioServicio.listaDeUsuarios();
		model.addAttribute("users", users);

		return "listaUsuarios";
	}

	// SAIDA FORMULARIO -- eliminar
	@RequestMapping("/admin/delete/{id}")
	public String borrarUsuario(@PathVariable("id") Long id) {

		UsuarioServicio.removeUser(id);

		return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/admin/listaUsuarios";
	}

	// ------------------------------------------------------------------------------

	// BUSCADOR USUARIO - Entrada
	@RequestMapping(value = "/admin/buscadorUsuario", method = RequestMethod.GET)
	public String buscadorUsuario(Model model, Usuario usuario) {
		model.addAttribute("mensaxe", "inicio");
		model.addAttribute("usuario", usuario);
		return "buscadorUsuario";
	}

	// SAIDA FORMULARIO BUSCADOR
	@RequestMapping(value = "/admin/buscadorUsuario", method = RequestMethod.POST)
	public String buscadorUsuario(Usuario usuario,Model model) {
		List<Usuario> lista  = UsuarioServicio.buscarUsuarioSimilarLogin(usuario.getLogin()) ;

		if (lista.isEmpty()){
			model.addAttribute("mensaxe", "lista vacia");
		}else{
			model.addAttribute("users", lista);
			model.addAttribute("mensaxe", "lista chea");
		}	
		
		return "buscadorUsuario";
	}
	//--------------------------------------------------------------
	
	//editarUsuario
	
	@RequestMapping("/admin/editarUsuario/{id}")
	public String editarUsuario(@PathVariable("id") Long id,Model model) {

        Usuario usuario = UsuarioServicio.buscarUsuario(id);
		model.addAttribute("usuario", usuario);
        return "editarUsuario";
	}
	
	// SAIDA FORMULARIO
		@RequestMapping(value = "/admin/updateUsuario", method = RequestMethod.POST)
		public String updateUsuario(@Valid Usuario usuario, BindingResult result) {
			if (result.hasErrors()) {
				return "editarUsuario";
			}
			
			UsuarioServicio.updateUsuario(usuario);
			return "redirect:/"+ConstantesUtil.SERVLET_XEOPESCA+"/admin/listaUsuarios";
		}
	
	

}