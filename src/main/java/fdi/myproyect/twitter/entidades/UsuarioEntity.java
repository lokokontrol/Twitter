package fdi.myproyect.twitter.entidades;

public class UsuarioEntity {

	String username;
	String password;
	
	Boolean login;
	
	public UsuarioEntity(){
		
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
	
	
	
}
