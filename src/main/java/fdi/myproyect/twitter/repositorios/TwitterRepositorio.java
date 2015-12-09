package fdi.myproyect.twitter.repositorios;


import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import fdi.myproyect.twitter.entidades.TweetEntity;

@Repository
public class TwitterRepositorio {
	
	@PersistenceContext
	private EntityManager em;
	
	 ArrayList<TweetEntity> listaTweets = new ArrayList<TweetEntity>();
	 
	 public void addTweet (TweetEntity tweet){
		 listaTweets.add(tweet);
		 
		 em.persist(tweet);
	 }
	 
	 public  ArrayList<TweetEntity> getAllTweets ()
	 {
		 return this.listaTweets;
	 }
	
}
