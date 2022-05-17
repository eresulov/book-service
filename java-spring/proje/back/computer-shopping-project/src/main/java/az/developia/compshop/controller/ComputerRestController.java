package az.developia.compshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.compshop.exception.MyRuntimeException;
import az.developia.compshop.model.Computer;
import az.developia.compshop.model.UserModel;
import az.developia.compshop.repository.ComputerRepository;
import az.developia.compshop.repository.UserRepository;

@RestController
@RequestMapping(path = "/computers")
@CrossOrigin(origins = "*")
public class ComputerRestController {

	@Autowired
	private ComputerRepository computerRepository;

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	public Computer save(@Valid @RequestBody Computer computer, BindingResult result) {
		if (result.hasErrors()) {
			throw new MyRuntimeException(result);
		}
		UserModel user = userRepository.findById(getUser()).get();

		computer.setUser(user);
		return computerRepository.save(computer);
	}

	@GetMapping
	public List<Computer> findAllByUsername() {
		return computerRepository.findAllByUsername(getUser());

	}
	
	
	@GetMapping(path = "/all")
	public List<Computer> findAll () {
		return computerRepository.findAll ( );

	}
	

	@DeleteMapping(path = "/{id}")
	public void deleteById(@PathVariable Integer id) {
		computerRepository.deleteById(id);

	}

	@GetMapping(path = "/{id}")
	public Computer findById(@PathVariable Integer id) {
		return computerRepository.findById(id).get();
	}
	
	@GetMapping(path = "/shopping/{id}")
	public Computer findByIdShopping(@PathVariable Integer id) {
		return computerRepository.findById(id).get();
	}
	

	private String getUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
