package az.pashabank.springsimpleproject.repositories;

import org.springframework.data.repository.CrudRepository;

import az.pashabank.springsimpleproject.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
