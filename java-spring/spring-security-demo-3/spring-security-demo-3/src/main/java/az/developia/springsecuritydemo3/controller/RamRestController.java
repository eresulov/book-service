package az.developia.springsecuritydemo3.controller;

import java.beans.Statement;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springsecuritydemo3.model.*;
import az.developia.springsecuritydemo3.repository.Ramrepo;


@Component
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/rams")

public class RamRestController {
	
@Autowired

private Ramrepo ramrepository;

	@GetMapping
	@PreAuthorize(value = "hasAuthority('get:ram')")
	public List<Ram> rams() {

		return ramrepository.findAll();
	}

	@PostMapping
	@PreAuthorize(value = "hasAuthority('save:ram')")
	public void saveRam(@RequestBody Ram ram) {
		ramrepository.save(ram);
	}
	
	@DeleteMapping(path ="/{id}")
	public void deleteById(@PathVariable Integer id) {
		ramrepository.deleteById(id);
		
	}
}