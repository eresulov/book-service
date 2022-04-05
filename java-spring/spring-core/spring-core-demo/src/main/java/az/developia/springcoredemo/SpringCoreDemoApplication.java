package az.developia.springcoredemo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

@SpringBootApplication
public class SpringCoreDemoApplication {

	public static void main(String[] args) {
		ApplicationContext c= SpringApplication.run(SpringCoreDemoApplication.class, args);
	Customer mycustomer=c.getBean(Customer.class);
	
	String[] beanadlari=c.getBeanDefinitionNames();
	System.out.println(Arrays.toString(beanadlari));
	
	Computer dell=c.getBean(Computer.class);
	System.out.println(dell);
	}

}
