package az.developia.springcoredemo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springcoredemo.model.Computer;
@RestController
@CrossOrigin(origins="*")
@RequestMapping(path = "/computers")
public class ComputerRestController {

@GetMapping
public Computer hello() {
	Computer hp=new Computer();
	hp.setModel("g63");
	hp.setName("hpnays");
	hp.setId(4);
	return hp;
}
}
