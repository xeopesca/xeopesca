package com.xeopesca.webapp.controller.publico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xeopesca.webapp.model.vos.Arte;
import com.xeopesca.webapp.model.vos.Usuario;

@Controller
public class LocaleJSON {
	@RequestMapping(value = "/public/locale", method = RequestMethod.GET)
	public @ResponseBody Arte getArteInJSON() {
 
		Arte a = new Arte();
		a.setActividade("probas");
		a.setCategoria("categoria");
		a.setNome("Nome arte");
		a.setId(1);
		a.setPath("/");
		return a;
 
	}

	
	@RequestMapping(value = "/public/locale/a", method = RequestMethod.GET)
	public @ResponseBody String getArteCadena() {
 
		Arte a = new Arte();
		a.setActividade("probas");
		a.setCategoria("categoria");
		a.setNome("Nome arte");
		a.setId(1);
		a.setPath("/");
		return a.toString();
 
	}
	
	@RequestMapping(value = "/public/locale/b", method = RequestMethod.GET)
	public String novoUsuario(Model model, Usuario usuario) {
	
		model.addAttribute("usuario", usuario);

		return "login";
	}

}



 
	
 