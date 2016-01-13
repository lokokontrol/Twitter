package fdi.myproyect.twitter.servicioAplicacion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import fdi.myproyect.twitter.entidades.UsuarioEntity;
import fdi.myproyect.twitter.repositorios.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioSA {
	
	UsuarioRepositorio repositorio;
	
	@Autowired
	public UsuarioSA (UsuarioRepositorio repositorio)
	{
		this.repositorio = repositorio;
	}
	
	public void addUsuario (UsuarioEntity usuario)
	{
		usuario.setLogin(true);
		repositorio.addUsuario(usuario);
	}

	/*public List<UsuarioEntity> getAllUsuario()
	{
		return repositorio.getListaUsuarios();
	}
	
	public void modificarUsuarioLogin(UsuarioEntity usuario){
		repositorio.modificarUsuarioLogin(usuario);
	}*/
	
	public void loguearse(UsuarioEntity usuario) {
		
		List<UsuarioEntity> arrayUsu = repositorio.getListaUsuarios();
		
		Iterator<UsuarioEntity> it = arrayUsu.iterator();
	
		while(it.hasNext()){
			UsuarioEntity usuarioAux = it.next();
			
			if (usuario.getUsername().equals(usuarioAux.getUsername()))
				if(usuario.getPassword().equals(usuarioAux.getPassword())){
					usuarioAux.setLogin(true);
					repositorio.modificarUsuarioLogin(usuarioAux);
				}
		}
	}
	
	public ModelAndView mostrarUsuario(){
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("usuarios", repositorio.getListaUsuarios());
		
		
		ModelAndView view = new ModelAndView("home", model);
		
		return view;	
	}
	
	public void desconectar(UsuarioEntity usuario){
		    List<UsuarioEntity> arrayUsu = repositorio.getListaUsuarios();
			
			Iterator<UsuarioEntity> it = arrayUsu.iterator();
			
			while(it.hasNext()){
				UsuarioEntity usuarioAux = it.next();
				System.out.println(usuarioAux.getUsername());
				System.out.println(usuarioAux.getLogin());
				if(usuarioAux.getLogin() == true){
					usuarioAux.setLogin(false);
					repositorio.modificarUsuarioLogin(usuarioAux);
				}
			}
	}
	
}

