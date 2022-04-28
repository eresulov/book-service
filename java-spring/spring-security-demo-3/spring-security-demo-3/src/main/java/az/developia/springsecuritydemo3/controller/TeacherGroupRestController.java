package az.developia.springsecuritydemo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springsecuritydemo3.model.TeacherGroup;
import az.developia.springsecuritydemo3.repository.TeacherGroupRepository;

@Component
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/teacher-groups")

public class TeacherGroupRestController {

	@Autowired

	private TeacherGroupRepository teachergrouprepository;

	@GetMapping

	public List<TeacherGroup> groups() {

		return teachergrouprepository.findAll();
	}

	@PostMapping
	public void saveGroup(@RequestBody TeacherGroup g) {
		teachergrouprepository.save(g);
	}

}