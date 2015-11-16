package fdi.myproyect.twitter.controladores;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fdi.myproyect.twitter.entidades.TweetEntity;
import fdi.myproyect.twitter.servicioAplicacion.TwitterSA;


@Controller
public class TwitterController {
	
	TwitterSA servicio ;
	
	@Autowired
	public TwitterController(TwitterSA servicio) {
		this.servicio = servicio;
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("tweets", servicio.getAllTweets());
		
		ModelAndView view = new ModelAndView("home",model) ;
						
		return view;		
		
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	String add(TweetEntity tweet){			
		servicio.addTweet(tweet);
		return "redirect:/"; // vuelve a entrar home() de arriba
	}	
	
	
	

}
