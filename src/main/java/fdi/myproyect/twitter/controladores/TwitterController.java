package fdi.myproyect.twitter.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fdi.myproyect.twitter.servicioAplicacion.TwitterSA;

@Controller
public class TwitterController {
	
	TwitterSA servicio ;
	
	@Autowired
	public TwitterController(TwitterSA servicio) {
		this.servicio = servicio;
	}
	
	
	

}
