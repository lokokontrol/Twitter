package fdi.myproyect.twitter.entidades;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
@Table(name="Usuario")
public class UsuarioEntity implements UserDetails{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String username;
	String password;
	
	Boolean enabled;
	
	private boolean accountExpired;
	
	private boolean accountLocked;
	
	private boolean credentialsExpired;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="USER_ROLES", joinColumns=@JoinColumn(name="user"),  uniqueConstraints=@UniqueConstraint(columnNames={"user", "role"}))
	private Collection<UserRole> roles;
	
	
	public UsuarioEntity(){
		
	}
	
	public UsuarioEntity(int id,String username, String password, boolean enabled){
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	
	public UsuarioEntity(String username, String password)
	{
		this.username = username;
		this.password = password;
		this.roles = new ArrayList<UserRole>();
	}
	
	public void setUsuarioEntity(int id,String username, String password, boolean enabled){
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
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
		return enabled;
	}

	public void setLogin(Boolean enabled) {
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return ! accountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return ! accountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return ! credentialsExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
}
