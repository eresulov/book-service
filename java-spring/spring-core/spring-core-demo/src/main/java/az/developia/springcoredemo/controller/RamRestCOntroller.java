package az.developia.springcoredemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springcoredemo.model.Ram;
@RestController
@CrossOrigin(origins="*")
public class RamRestCOntroller {
	List<Ram> rams=new ArrayList<Ram>() ;{
	Ram r=new Ram();
	r.setId(1);
	r.setModel("asdasd");
	r.setSize(8);
	r.setName("8 bitli ram");
	rams.add(r);
	Ram r2=new Ram();
	r2.setId(2);
	r2.setModel("GG8");
	r2.setName("ram16");
	r2.setSize(16);
	rams.add(r2);

	Ram r3=new Ram();
	r3.setId(3);
	r3.setModel("GG8");
	r3.setName("ram16");
	r3.setSize(16);
	rams.add(r3);
	}
	
@GetMapping(path = "/rams")

public List<Ram> rams () {
	
	
	
return rams;
}

@PostMapping(path="/rams")
public void saveRam(@RequestBody Ram ram ) {
	System.out.println(ram.getModel());
}
}
