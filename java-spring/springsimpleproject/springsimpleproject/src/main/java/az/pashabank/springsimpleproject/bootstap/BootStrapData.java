package az.pashabank.springsimpleproject.bootstap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import az.pashabank.springsimpleproject.model.AuthorModel;
import az.pashabank.springsimpleproject.model.Book;
import az.pashabank.springsimpleproject.repositories.AuthorRepository;
import az.pashabank.springsimpleproject.repositories.BookRepository;



@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}



	@Override
	public void run(String... args) throws Exception {
	AuthorModel emral = new AuthorModel("Emral","Resulov");
	Book ddd= new Book("Domain Driven Design","123123");
		emral.getBooks().add(ddd);
		ddd.getAuthors().add(emral);

	authorRepository.save(emral);
	bookRepository.save(ddd);
	
	AuthorModel tahir=new AuthorModel("Tahir","Xelilov");
	Book ttt=new Book("Java","111222");
	tahir.getBooks().add(ttt);
	ttt.getAuthors().add(tahir);
	
	authorRepository.save(tahir);
	bookRepository.save(ttt);
	
	System.out.println("Started Bootstrap");
	System.out.println("Number of books"+bookRepository.count());

	
	}
		

}

