package az.pashabank.springsimpleproject.repositories;

import org.springframework.data.repository.CrudRepository;

import az.pashabank.springsimpleproject.model.AuthorModel;

public interface AuthorRepository extends CrudRepository<AuthorModel, Long>{

}
