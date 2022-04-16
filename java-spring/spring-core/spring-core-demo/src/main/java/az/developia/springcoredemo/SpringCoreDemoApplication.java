package az.developia.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class SpringCoreDemoApplication {
	
	


	public static void main(String[] args) {
		ApplicationContext c= SpringApplication.run(SpringCoreDemoApplication.class, args);

	

	}
}