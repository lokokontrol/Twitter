package fdi.myproyect.twitter.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fdi.myproyect.twitter.entidades.UsuarioEntity;

import fdi.myproyect.twitter.servicioAplicacion.UsuarioSA;

@Controller
public class UsuarioController {

	UsuarioSA servicioUsuario;
	
	@Autowired
	public UsuarioController(UsuarioSA servicio)
	{
		this.servicioUsuario = servicio;
	}
		
	@RequestMapping(value="/", method = RequestMethod.POST)
	String login(UsuarioEntity usuario){
		
		 	servicioUsuario.loguearse(usuario);
			
			return "redirect:/paginaTwitter";
	}
	
	
	//Para mostrar los usuarios en Home
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		return servicioUsuario.mostrarUsuario();

	}
	
	@RequestMapping(value = "/desconectar", method = RequestMethod.POST)
	public String desconectar(UsuarioEntity usuario) {	
		
        servicioUsuario.desconectar(usuario);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public String registrar(UsuarioEntity usuario) {	
		
		servicioUsuario.addUsuario(usuario);
		
		return "redirect:/paginaTwitter";

	}
	

	
	
}
