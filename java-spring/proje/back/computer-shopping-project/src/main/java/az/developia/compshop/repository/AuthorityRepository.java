package az.developia.compshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.compshop.model.AuthorityModel;

public interface AuthorityRepository extends JpaRepository<AuthorityModel, Integer> {

}
