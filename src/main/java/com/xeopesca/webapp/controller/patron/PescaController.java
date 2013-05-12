package com.xeopesca.webapp.controller.patron;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xeopesca.util.ConstantesUtil;
import com.xeopesca.util.HelperDateUtil;
import com.xeopesca.webapp.view.FaenaBuscador;
import com.xeopesca.webapp.model.servicios.ArteServicio;
import com.xeopesca.webapp.model.servicios.BarcoServicio;
import com.xeopesca.webapp.model.servicios.EspecieServicio;
import com.xeopesca.webapp.model.servicios.FaenaServicio;
import com.xeopesca.webapp.model.servicios.LanceServicio;
import com.xeopesca.webapp.model.servicios.ParametriaServicio;
import com.xeopesca.webapp.model.servicios.PescaServicio;
import com.xeopesca.webapp.model.servicios.UsuarioServicio;

import com.xeopesca.webapp.model.vos.Parametria;
import com.xeopesca.webapp.model.vos.Pesca;
import com.xeopesca.webapp.model.vos.Usuario;


@Controller
public class PescaController {
   
    
    
		
	@RequestMapping(value = "/patron/deletePesca", method = RequestMethod.POST)
	public String deleteLance(Pesca pesca, BindingResult result) {
		Pesca pescaBD = PescaServicio.findById(pesca);
		PescaServicio.removePesca(pesca);
		
		return "redirect:/" + ConstantesUtil.SERVLET_XEOPESCA
				+ "/patron/novoLance/" + pescaBD.getLance().getIdfaena();

	}
	
	
	
    
}