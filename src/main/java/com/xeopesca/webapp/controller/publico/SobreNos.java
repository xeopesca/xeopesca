package com.xeopesca.webapp.controller.publico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Josecho
 *
 */
@Controller
public class SobreNos {
	/**
	 * Web Sobre Nós
	 * @return String
	 */
	@RequestMapping(value = "/public/sobreNos", method = RequestMethod.GET)
	public String licenza() {
	
		return "sobreNos";
	}

}
