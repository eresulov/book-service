package az.developia.springcoredemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springcoredemo.model.Student;
@RequestMapping(path = "/students")
@RestController
@CrossOrigin(origins="*")
public class StudentRestController {
List<Student> students=new ArrayList<Student>();
{
	Student std1=new Student();
  std1.setName("Emral");
  std1.setSurname("Resulov");
	std1.setId(1);
	std1.setPhone("0708788867");
	std1.setAddress("Genclik");
	//authentication və authorization
	Student std2=new Student();
	 std2.setName("Murad");
	 std2.setSurname("Mirzeyev");
		std2.setId(2);
		std2.setPhone("0556756643");
		std2.setAddress("Sumqayit");
		students.add(std2);
		students.add(std1);
}
@GetMapping
public List<Student> student () {
	return students;
}
@PostMapping
public void Registration(@RequestBody Student student) {
	System.out.println(student.getName()+" "+student.getId()+" "+student.getSurname()+" "+student.getAddress()+" "+student.getPhone());
}

}
