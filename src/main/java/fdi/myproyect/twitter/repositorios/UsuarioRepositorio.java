package fdi.myproyect.twitter.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transaction;

import org.springframework.stereotype.Repository;

import fdi.myproyect.twitter.entidades.UsuarioEntity;

@Repository
public class UsuarioRepositorio {

	List<UsuarioEntity> listaUsuarios;
	
	//private SessionFactory sessionFactory;

	@PersistenceContext
	private EntityManager em;
	
	/*@Autowired
	public UsuarioRepositorio(SessionFactory sf){
		//this.sessionFactory = sf;
		
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
      //  this.sessionFactory = sessionFactory;
    }
	*/
	
	public UsuarioEntity addUsuario(UsuarioEntity usuario)
	{
		//Session session =sessionFactory.getCurrentSession();
		//session.save(usuario);
		
		//EntityManagerFactory ef = Persistence.createEntityManagerFactory("UsuarioSA");
		
		//EntityManager em = ef.createEntityManager();
		
			UsuarioEntity usu = em.merge(usuario);
		return usu;
		
	}
	
	public void modificarUsuarioLogin(UsuarioEntity usuario){
		
		em.merge(usuario);
	}

	public List<UsuarioEntity> getListaUsuarios() {

	/*	/*Session session =sessionFactory.openSession();
		this.listaUsuarios = (List<UsuarioEntity>) session.createQuery("from UsuarioEntity").list();	
		*/
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<UsuarioEntity> q = cb.createQuery(UsuarioEntity.class);
	
		
		q.from(UsuarioEntity.class);
		listaUsuarios = em.createQuery(q).getResultList();  

		return this.listaUsuarios;
		
	}
}
	
	

