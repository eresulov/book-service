package az.developia.spring.RestController;

import java.nio.file.Path;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/students")
public class StudentRestController {
public String hello() {
	return "Hello";
}
}
