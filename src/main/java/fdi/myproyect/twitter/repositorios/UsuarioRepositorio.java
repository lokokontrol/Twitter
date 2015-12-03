package fdi.myproyect.twitter.repositorios;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fdi.myproyect.twitter.entidades.UsuarioEntity;

@Repository
public class UsuarioRepositorio {

	ArrayList<UsuarioEntity> listaUsuarios = new ArrayList<UsuarioEntity>();
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public UsuarioRepositorio(SessionFactory sf){
		this.sessionFactory = sf;
		
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Transactional
	public void addUsuario(UsuarioEntity usuario)
	{
		Session session =sessionFactory.openSession();
		session.persist(usuario);
	}

	public ArrayList<UsuarioEntity> getListaUsuarios() {
		return this.listaUsuarios;
	}
	
	
}
