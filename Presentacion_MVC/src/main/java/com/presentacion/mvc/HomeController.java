package com.presentacion.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entidades.seguridad.SEG_UsuarioEL;
import com.logica.seguridad.SEG_UsuarioBL;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("home", "command", new SEG_UsuarioEL());
	}

	@RequestMapping(value = "/VerificarAcceso", method = RequestMethod.POST)
	public String VerificarAcceso(@ModelAttribute("SpringWeb")SEG_UsuarioEL u, 
								ModelMap model){
		try {
			String Usuario = u.getLogin();
			String Password = u.getPassword();			
			SEG_UsuarioEL usu = SEG_UsuarioBL.Instancia().VerificarAcceso(
																Usuario, Password);
			return "frmMenuPrincipal";													
		} catch (Exception e) {
			return "frmError";
		}
	}
}
