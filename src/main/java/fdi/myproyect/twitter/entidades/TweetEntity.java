package fdi.myproyect.twitter.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Tweet")
public class TweetEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@ManyToOne
	UsuarioEntity usuario;
	String texto;
	

	public TweetEntity(){};


	public TweetEntity(int id,UsuarioEntity usuario, String texto)
	{
	
		this.id = id;
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
