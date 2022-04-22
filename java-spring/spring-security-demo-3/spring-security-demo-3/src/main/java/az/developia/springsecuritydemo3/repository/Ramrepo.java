package az.developia.springsecuritydemo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springsecuritydemo3.model.Ram;

public interface Ramrepo extends JpaRepository<Ram, Integer> {

}
