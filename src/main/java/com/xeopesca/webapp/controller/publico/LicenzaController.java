package com.xeopesca.webapp.controller.publico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Josecho
 *
 */
@Controller
public class LicenzaController {
	
	/**
	 * Web da licenza
	 * @return String
	 */
	@RequestMapping(value = "/public/licenza", method = RequestMethod.GET)
	public String licenza() {
	
		return "licenza";
	}
}
