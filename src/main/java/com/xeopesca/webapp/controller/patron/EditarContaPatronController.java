/* --------------------------------------------------------------------
 This file is part of xeoPesca

Copyright (C) 2013 - Pablo Belay Fernández 
This program is free software: you can redistribute it
and/or modify it under the terms of the GNU General
Public License as published by the Free Software
Foundation, either version 3 of the License, or (at your
option) any later version.
This program is distributed in the hope that it will be
useful, but WITHOUT ANY WARRANTY; without even the
implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE. See the GNU General Public License
for more details.
You should have received a copy of the GNU General Public
License along with this program. If not, see
http://www.gnu.org/licenses/gpl-3.0-standalone.html
--------------------------------------------------------------------*/
package com.xeopesca.webapp.controller.patron;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xeopesca.webapp.model.servicios.UsuarioServicio;
import com.xeopesca.webapp.model.vos.Usuario;

/**
 * @author belay
 *
 */
@Controller
public class EditarContaPatronController {

	@Autowired
	private Validator validator;

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

		/**
		 * Formulario de edición da conta dun patrón
		 * @param model
		 * @return plantilla tiles a cargar
		 */
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