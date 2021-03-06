package az.developia.springcoredemo.controller;

import java.beans.Statement;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springcoredemo.model.Ram;
import az.developia.springcoredemo.repo.RamRepo;

@Component
@RestController
@CrossOrigin(origins = "*")
public class RamRestCOntroller {

	@Autowired
	private RamRepo ramrepository;

	@GetMapping(path = "/rams")

	public List<Ram> rams() {

		return ramrepository.findAll();
	}

	@PostMapping(path = "/rams")
	public void saveRam(@RequestBody Ram ram) {
		ramrepository.save(ram);
	}
	
	@DeleteMapping(path ="/rams/{id}")
	public void deleteById(@PathVariable Integer id) {
		ramrepository.deleteById(id);
		
	}
}