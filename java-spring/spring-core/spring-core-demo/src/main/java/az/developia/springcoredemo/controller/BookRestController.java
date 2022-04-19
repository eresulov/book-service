package az.developia.springcoredemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springcoredemo.model.Book;
import az.developia.springcoredemo.model.Student;
@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/books")
public class BookRestController {
	List<Book> booksDatabase=new ArrayList<Book>();
	{
		Book book1=new Book();
		book1.setId(1);
		book1.setName("The Farm");
		book1.setPrice(15);
		booksDatabase.add(book1);
		
		Book book2=new Book();
		book2.setId(2);
		book2.setName("The Universe in a Nutshell");
		book2.setPrice(150);
		booksDatabase.add(book2);
		
		Book book3=new Book();
		book3.setId(3);
		book3.setName("Java ogrenim");
		book3.setPrice(110);
		booksDatabase.add(book3);
		
		Book book4=new Book();
		book4.setId(4);
		book4.setName("Pyhton esaslari");
		book4.setPrice(130);
		booksDatabase.add(book4);
	}
@GetMapping
public Book getBook() {
	Book book1=new Book();
	book1.setId(1);
book1.setName("Heyvanistan");
book1.setPrice(15);
	return book1;
}

@GetMapping(path = "/search")
public List<Book> bookSearch(@RequestParam(name = "q") String q) {
	List<Book> searchResults=new ArrayList<Book>();
	for (Book b : booksDatabase) {
		if(b.getName().toLowerCase().contains(q.toLowerCase())) {
			searchResults.add(b);
		}
	}
	return booksDatabase;
}
@PostMapping
public void addBook(@RequestBody Book book) {
	System.out.println(book.getName());
}
}
