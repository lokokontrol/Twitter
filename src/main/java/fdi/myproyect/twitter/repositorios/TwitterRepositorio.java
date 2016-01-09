package fdi.myproyect.twitter.repositorios;



import java.util.List;


import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	 
	 @SuppressWarnings("unchecked")
	 	public List<TweetEntity> getAllTweetsByUser(int id){
		 
		
		  Query query = em.createQuery("SELECT c FROM TweetEntity c where c.usuario.id =" + id);
		
		 return  listaTweets = query.getResultList();
	 }
	
}
