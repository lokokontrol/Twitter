package fdi.myproyect.twitter.servicioAplicacion;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import fdi.myproyect.twitter.entidades.TweetEntity;
import fdi.myproyect.twitter.entidades.UsuarioEntity;
import fdi.myproyect.twitter.repositorios.TwitterRepositorio;
import fdi.myproyect.twitter.repositorios.UsuarioRepositorio;

@Service
@Transactional
public class TwitterSA {
	
	TwitterRepositorio repositorioTwitter;
	UsuarioRepositorio repositorioUsuario;
	
	@Autowired
	public TwitterSA(TwitterRepositorio repositorio,UsuarioRepositorio repositorioUsuario)
	{
		this.repositorioTwitter = repositorio;
		this.repositorioUsuario = repositorioUsuario;
	}
	
	public void addTweet(TweetEntity tweet){
		
		List<UsuarioEntity> arrayUsu = repositorioUsuario.getListaUsuarios();
		
		Iterator<UsuarioEntity> it = arrayUsu.iterator();
		
		while(it.hasNext()){
			UsuarioEntity usuarioAux = it.next();
			if(usuarioAux.getLogin() == true)
				tweet.setUsuario(usuarioAux);
		}
		
		repositorioTwitter.addTweet(tweet);
	}
	
	 public  ModelAndView getAllTweets(){
		 
		 Map<String, Object> model = new HashMap<String, Object>();
			
		 model.put("tweets", this.repositorioTwitter.getAllTweets());
			
	     ModelAndView view = new ModelAndView("paginaTwitter", model);
			
		 return view;
	 }
	
	 public ModelAndView getAllTweetsByUser(int id){
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("tweets", this.repositorioTwitter.getAllTweetsByUser(id));
		
		ModelAndView view = new ModelAndView("tweets", model);
		
		return view;
	 }

}
