package fdi.myproyect.twitter.controladores;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import fdi.myproyect.twitter.servicioAplicacion.UsuarioSA;

@Controller
public class RegistroController {

	UsuarioSA servicio ;
	
	@Autowired
	public RegistroController(UsuarioSA servicio)
	{
		this.servicio = servicio;
	}
	
	@RequestMapping(value = "/registro", method = RequestMethod.GET)
	public ModelAndView registro() {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		ModelAndView view = new ModelAndView("registro",model) ;
						
		return view;	
		
	}
}
