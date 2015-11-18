package fdi.myproyect.twitter.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fdi.myproyect.twitter.servicioAplicacion.UsuarioSA;

@Controller
public class UsuarioController {

	UsuarioSA servicio;
	
	@Autowired
	public UsuarioController(UsuarioSA servicio)
	{
		this.servicio = servicio;
	}
		
}
