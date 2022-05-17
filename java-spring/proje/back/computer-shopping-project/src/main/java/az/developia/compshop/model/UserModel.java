package az.developia.compshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserModel {
	@Id
	private String username;
	private String password;
	private Boolean enabled;
	
	private String name;
	private String phone;
	
}