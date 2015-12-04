package fdi.myproyect.twitter.servicioAplicacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fdi.myproyect.twitter.entidades.UsuarioEntity;
import fdi.myproyect.twitter.repositorios.UsuarioRepositorio;

@Service
public class UsuarioSA {
	
	UsuarioRepositorio repositorio;
	
	@Autowired
	public UsuarioSA (UsuarioRepositorio repositorio)
	{
		this.repositorio = repositorio;
	}
	
	public void addUsuario (UsuarioEntity usuario)
	{
		repositorio.addUsuario(usuario);
	}

	public List<UsuarioEntity> getAllUsuario()
	{
		return repositorio.getListaUsuarios();
	}
	
	
}

