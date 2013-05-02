package com.xeopesca.webapp.controller.patron;

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
public class EditarContaPatronController {

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	// Entrada FORMULARIO
		@RequestMapping(value = "/patron/editarConta")
		public String editarConta(Model model) {
			String saida = "editarContaPatron";
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String name = auth.getName();

			Usuario usuario = UsuarioServicio.getUsuario(name);
			model.addAttribute("usuario", usuario);

			return saida;
		}

	

	

}