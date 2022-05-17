package az.developia.travelticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import az.developia.travelticket.model.User;
import az.developia.travelticket.repository.UserRepository;
@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
public class UserRestController {
	@Autowired
private UserRepository userRepository;
	@PostMapping(value = "/saveUser")
	public User save (@RequestBody User user) {
		return userRepository.save(user);
	}
	@GetMapping
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
}