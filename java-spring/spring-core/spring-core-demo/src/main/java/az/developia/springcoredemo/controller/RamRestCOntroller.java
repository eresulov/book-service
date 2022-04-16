package az.developia.springcoredemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springcoredemo.model.Ram;
@RestController
@CrossOrigin(origins="*")
public class RamRestCOntroller {

@GetMapping(path = "/rams")
public List<Ram> rams () {
	Ram r=new Ram();
	r.setSize(8);
	r.setName("8 bitli ram");

	Ram r2=new Ram();
	r2.setModel("GG8");
	r2.setName("ram16");
	r2.setSize(16);
	

	Ram r3=new Ram();
	r3.setModel("GG8");
	r3.setName("ram16");
	r3.setSize(16);
	
	List<Ram> rams=new ArrayList<Ram>() ;
	rams.add(r);
	rams.add(r2);
	rams.add(r3);
return rams;
}
}
