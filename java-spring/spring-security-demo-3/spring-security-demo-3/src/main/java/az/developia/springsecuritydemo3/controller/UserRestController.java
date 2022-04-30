package az.developia.springsecuritydemo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springsecuritydemo3.model.AuthorityModel;
import az.developia.springsecuritydemo3.model.UserModel;
import az.developia.springsecuritydemo3.repository.AuthorityRepository;
import az.developia.springsecuritydemo3.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(name = "users")
public class UserRestController {
	@Autowired
	private UserRepository userrepository;

	@Autowired
	private AuthorityRepository authorityrepository;

	@GetMapping(path = "/login")
	public void login() {

	}

	@PostMapping(path = "/signup")
	public void signup(@RequestBody UserModel user) {
System.out.println(user.getUsername()+" "+user.getPassword());

BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
String encodedPassword = "{bcrypt}" +encoder.encode(user.getPassword());
user.setPassword(encodedPassword);
user.setEnabled(true); //  user i bazaya save etmemisden evvel enabled ni true etmeliyik 
//huquqlar elave olunmalidi
userrepository.save(user);
List<AuthorityModel> teacherAuthorities=new ArrayList<AuthorityModel>();
AuthorityModel teacher =new AuthorityModel();
teacher.setUsername(user.getUsername());
teacher.setAuthority("teacher");
teacherAuthorities.add(teacher);

AuthorityModel saveStudent =new AuthorityModel();
saveStudent.setUsername(user.getUsername());
saveStudent.setAuthority("save:student");
teacherAuthorities.add(saveStudent);
authorityrepository.saveAll(teacherAuthorities);
	}
}
