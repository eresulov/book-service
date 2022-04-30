package az.developia.springsecuritydemo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springsecuritydemo3.model.AuthorityModel;

public interface AuthorityRepository extends JpaRepository<AuthorityModel, Integer> {

}
