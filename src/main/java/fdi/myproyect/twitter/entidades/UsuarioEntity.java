package fdi.myproyect.twitter.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuarios")
public class UsuarioEntity implements Serializable {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	String username;
	String password;	
	
	Boolean login;
	
	
	public UsuarioEntity(){
		
	}
	
	public UsuarioEntity(int id,String username, String password, boolean login)
	{
		this.id = id;
		this.username = username;
		this.password = password;
		this.login = login;
		
	}
	
	public UsuarioEntity(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
