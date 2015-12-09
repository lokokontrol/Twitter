package fdi.myproyect.twitter.repositorios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
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
		this.sessionFactory = sf;
		
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	*/
	
	public void addUsuario(UsuarioEntity usuario)
	{
		//Session session =sessionFactory.getCurrentSession();
		//session.save(usuario);
		
		em.persist(usuario);
		
	}

	@SuppressWarnings("unchecked")
	public List<UsuarioEntity> getListaUsuarios() {
		//Session session =sessionFactory.openSession();
		//this.listaUsuarios = session.createSQLQuery("select * from usuario").list();
		//this.listaUsuarios = (List<UsuarioEntity>) session.createQuery("from UsuarioEntity").list();
		
		//session.close();
		
	//	this.listaUsuarios = (List<UsuarioEntity>) session.createQuery("from UsuarioEntity").list();
		
		
		
		return this.listaUsuarios;
	}
	
	
}
