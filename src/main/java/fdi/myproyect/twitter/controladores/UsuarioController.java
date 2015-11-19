package fdi.myproyect.twitter.controladores;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fdi.myproyect.twitter.entidades.TweetEntity;
import fdi.myproyect.twitter.entidades.UsuarioEntity;
import fdi.myproyect.twitter.servicioAplicacion.UsuarioSA;

@Controller
public class UsuarioController {

	UsuarioSA servicio;
	
	@Autowired
	public UsuarioController(UsuarioSA servicio)
	{
		this.servicio = servicio;
		
	}
		
	@RequestMapping(value="/", method = RequestMethod.POST)
	String add(UsuarioEntity usuario){
		servicio.addUsuario(usuario);
		
		return "redirect:/paginaTwitter";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		ModelAndView view = new ModelAndView("home", null);
			
		return view;

		
		
	}
	
}
