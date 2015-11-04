package fdi.myproyect.twitter.repositorios;


import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import fdi.myproyect.twitter.entidades.TweetEntity;

@Repository
public class TwitterRepositorio {
	
	
	 ArrayList<TweetEntity> listaTweets = new ArrayList<TweetEntity>();
	 
	 public void addTweet (TweetEntity tweet){
		 listaTweets.add(tweet);
	 }
	 
	 public  ArrayList<TweetEntity> getAllTweets ()
	 {
		 return this.listaTweets;
	 }
	
}
