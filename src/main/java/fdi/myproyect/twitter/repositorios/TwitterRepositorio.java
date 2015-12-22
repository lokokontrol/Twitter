package fdi.myproyect.twitter.repositorios;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import fdi.myproyect.twitter.entidades.TweetEntity;

@Repository
public class TwitterRepositorio {
	

	@PersistenceContext
	private EntityManager em;
	
	
	 List<TweetEntity> listaTweets;
	 
	 public void addTweet (TweetEntity tweet){
		 //listaTweets.add(tweet);
		 
				em.merge(tweet);
			
	 }
	 
	 public  List<TweetEntity> getAllTweets ()
	 {
		// return this.listaTweets;
		 CriteriaBuilder cb = em.getCriteriaBuilder();

			CriteriaQuery<TweetEntity> q = cb.createQuery(TweetEntity.class);
			
			@SuppressWarnings("unused")
			Root<TweetEntity> c = q.from(TweetEntity.class);
			listaTweets = em.createQuery(q).getResultList();  

			return this.listaTweets;
	 }
	
}
