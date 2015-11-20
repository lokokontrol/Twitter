package fdi.myproyect.twitter.repositorios;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import fdi.myproyect.twitter.entidades.UsuarioEntity;

@Repository
public class UsuarioRepositorio {

	ArrayList<UsuarioEntity> listaUsuarios = new ArrayList<UsuarioEntity>();
	
	public void addUsuario(UsuarioEntity usuario)
	{
		listaUsuarios.add(usuario);
	}

	public ArrayList<UsuarioEntity> getListaUsuarios() {
		return this.listaUsuarios;
	}
	
	
}
