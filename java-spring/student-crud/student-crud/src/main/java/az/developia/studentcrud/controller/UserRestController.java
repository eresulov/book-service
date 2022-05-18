package az.developia.studentcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.studentcrud.model.AuthorityModel;
import az.developia.studentcrud.model.UserModel;
import az.developia.studentcrud.repository.AuthorityRepository;
import az.developia.studentcrud.repository.UserRepository;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
public class UserRestController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@PostMapping
	public UserModel addUser(@RequestBody UserModel user) {
		user.setPassword("{noop}"+user.getPassword());
		user.setEnabled(true);
		UserModel savedUser= userRepository.save(user);
		
		AuthorityModel authority= new AuthorityModel();
		authority.setUsername(user.getUsername());
		authority.setAuthority("teacher");
		authorityRepository.save(authority);	
		//authority ni database e save edirik
		return savedUser;
	}
@GetMapping(path = "/login")
public void login() {
	//bu linke gondereceyik username ve parolu success gelse dogrudur username
	//parol duz yazmisiq ya yox duzyazmisiqsa student sehifesine kececik
}
}