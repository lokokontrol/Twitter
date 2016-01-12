package fdi.myproyect.twitter.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import fdi.myproyect.twitter.entidades.TweetEntity;
import fdi.myproyect.twitter.servicioAplicacion.TwitterSA;
import fdi.myproyect.twitter.servicioAplicacion.UsuarioSA;

@Controller
public class TwitterController {
	
	TwitterSA servicioTwitter ;
	
	@Autowired
	public TwitterController(TwitterSA servicioTwitter,UsuarioSA servicioUsuario) {
		this.servicioTwitter = servicioTwitter;
	}
	
	@RequestMapping(value = "/paginaTwitter", method = RequestMethod.GET)
	public ModelAndView paginaTwitter() {
		return servicioTwitter.getAllTweets();
	}

	@RequestMapping(value="/paginaTwitter", method = RequestMethod.POST)
	String add(TweetEntity tweet){
		
		servicioTwitter.addTweet(tweet);
		
		return "redirect:/paginaTwitter";
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ModelAndView user(@PathVariable(value="id") int id) {
		
		return servicioTwitter.getAllTweetsByUser(id);
	}

	
	
}
