package com.xeopesca.webapp.controller.administrador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Usuario;

@Controller
public class LoginController {

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	// ENTRADA FORMULARIO
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String novoUsuario(Model model, Usuario usuario) {
		model.addAttribute("usuario", usuario);

		return "login";
	}

	// SAIDA FORMULARIO
	@RequestMapping(value = "/loginProcess")
	public String login(Model model) {
		String saida = "login";
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();

		Usuario user = UsuarioServicio.getUsuario(name);

		if (user.getTipousuario().equals("ROLE_ADMIN")) {
			saida = "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/admin/listaUsuarios";
		} else if (user.getTipousuario().equals("ROLE_ARMADOR")) {
			saida = "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/armador";
		} else if (user.getTipousuario().equals("ROLE_PATRON")) {
			saida = "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/indexPatron";
		} else if (user.getTipousuario().equals("ROLE_ADMNISTRACION")) {
			saida = "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/indexAdministracion";
		}

		return saida;
	}

	// SAIDA FORMULARIO
	@RequestMapping(value = "/editarConta")
	public String editarConta(Model model) {
		String saida = "editarConta";
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String name = auth.getName();

		Usuario usuario = UsuarioServicio.getUsuario(name);
		model.addAttribute("usuario", usuario);

		return saida;
	}

	// SAIDA FORMULARIO
	@RequestMapping(value = "/editarConta", method = RequestMethod.POST)
	public String updateUsuario(@Valid Usuario usuario, BindingResult result) {
		String saida = "";
		if (result.hasErrors()) {
			return "editarConta";
		}

		UsuarioServicio.updateUsuario(usuario);
		
		if (usuario.getTipousuario().equals(ConstantesUtil.ROLE_ADMIN)){
			saida = "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/listaUsuarios";
		}else if (ConstantesUtil.ROLE_ARMADOR.equals(usuario.getTipousuario())){
			saida = "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
					+ "/indexArmador";
		}
		return saida;
	}

}