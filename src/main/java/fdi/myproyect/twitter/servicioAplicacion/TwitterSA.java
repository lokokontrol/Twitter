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

@Service
@Transactional
public class TwitterSA {
	
	TwitterRepositorio repositorio;
	UsuarioSA servicioUsuario;
	
	@Autowired
	public TwitterSA(TwitterRepositorio repositorio,UsuarioSA servicioUsuario)
	{
		this.repositorio = repositorio;
		this.servicioUsuario = servicioUsuario;
	}
	
	public void addTweet(TweetEntity tweet){
		
		List<UsuarioEntity> arrayUsu = servicioUsuario.getAllUsuario();
		
		Iterator<UsuarioEntity> it = arrayUsu.iterator();
		
		while(it.hasNext()){
			UsuarioEntity usuarioAux = it.next();
			if(usuarioAux.getLogin() == true)
				tweet.setUsuario(usuarioAux);
		}
		
		repositorio.addTweet(tweet);
	}
	
	 public  ModelAndView getAllTweets(){
		 
		 Map<String, Object> model = new HashMap<String, Object>();
			
		 model.put("tweets", this.repositorio.getAllTweets());
			
	     ModelAndView view = new ModelAndView("paginaTwitter", model);
			
		 return view;
	 }
	
	 public ModelAndView getAllTweetsByUser(int id){
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("tweets", this.repositorio.getAllTweetsByUser(id));
		
		ModelAndView view = new ModelAndView("tweets", model);
		
		return view;
	 }

}
