package fdi.myproyect.twitter.entidades;


public class TweetEntity {
	
	UsuarioEntity usuario;
	String texto;
	

	public TweetEntity(){};


	public TweetEntity(UsuarioEntity usuario, String texto)
	{
		this.usuario = usuario;
		this.texto = texto;
	}	
	
	public UsuarioEntity getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
}
