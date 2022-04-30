package azdevelopia.springticketbooking.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "/users")
public class UserModel {
	@Id	
private String username;
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
public Boolean getEnabled() {
	return enabled;
}
public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
}
private String password;
private Boolean enabled; // false olur default olarag 
}
