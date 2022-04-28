package az.developia.springsecuritydemo3.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springsecuritydemo3.model.UserModel;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/users")
public class UserRestController {

	@GetMapping(path = "/login")
	public void login () {
		
	}
	@PostMapping(path = "/signup")
	public void signup(UserModel user) {
		System.out.println(user.getUsername());
	}
}
