package az.developia.compshop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.compshop.model.AuthorityModel;
import az.developia.compshop.model.UserModel;
import az.developia.compshop.repository.AuthorityRepository;
import az.developia.compshop.repository.UserRepository;

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
		Optional<UserModel> userOptional = userRepository.findById(user.getUsername());
		if (userOptional.isPresent()) {
			user.setUsername("");
			return user;
		} else {
			user.setPassword("{noop}" + user.getPassword());
			user.setEnabled(true);
			UserModel savedUser = userRepository.save(user);

			AuthorityModel authority = new AuthorityModel();
			authority.setUsername(user.getUsername());
			authority.setAuthority("seller");
			authorityRepository.save(authority);

			return savedUser;
		}

	}

	@GetMapping(path = "/login")
	public void login() {

	}

}
