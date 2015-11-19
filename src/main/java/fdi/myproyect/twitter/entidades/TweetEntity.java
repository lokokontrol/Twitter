package fdi.myproyect.twitter.entidades;


public class TweetEntity {
	
	String usuario;
	String texto;
	

	public TweetEntity(){};


	public TweetEntity(String usuario, String texto)
	{
		this.usuario = usuario;
		this.texto = texto;
	}	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
}
