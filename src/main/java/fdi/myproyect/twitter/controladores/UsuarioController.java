package fdi.myproyect.twitter.controladores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
		
		 List<UsuarioEntity> arrayUsu = servicioUsuario.getAllUsuario();
			
			Iterator<UsuarioEntity> it = arrayUsu.iterator();
		//	boolean encontrado =false;
			while(it.hasNext()){
				UsuarioEntity usuarioAux = it.next();
				
				if (usuario.getUsername().equals(usuarioAux.getUsername()))
					if(usuario.getPassword().equals(usuarioAux.getPassword())){
						usuarioAux.setLogin(true);
						servicioUsuario.modificarUsuarioLogin(usuarioAux);
						//encontrado = true;
					}
			
			}
			
			return "redirect:/paginaTwitter";
	}
	
	
	//Para mostrar los usuarios en Home
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("usuarios", servicioUsuario.getAllUsuario());
		
		
		ModelAndView view = new ModelAndView("home", model);
		
		
			
		return view;
			
		
	}
	
	@RequestMapping(value = "/desconectar", method = RequestMethod.POST)
	public String desconectar(UsuarioEntity usuario) {	
	

       List<UsuarioEntity> arrayUsu = servicioUsuario.getAllUsuario();
		
		Iterator<UsuarioEntity> it = arrayUsu.iterator();
		
		while(it.hasNext()){
			UsuarioEntity usuarioAux = it.next();
			System.out.println(usuarioAux.getUsername());
			System.out.println(usuarioAux.getLogin());
			if(usuarioAux.getLogin() == true){
				usuarioAux.setLogin(false);
				servicioUsuario.modificarUsuarioLogin(usuarioAux);
			}
		}
		
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	public String registrar(UsuarioEntity usuario) {	
		usuario.setLogin(true);
		servicioUsuario.addUsuario(usuario);
		
		return "redirect:/paginaTwitter";
		
		
	}
	

	
	
}
