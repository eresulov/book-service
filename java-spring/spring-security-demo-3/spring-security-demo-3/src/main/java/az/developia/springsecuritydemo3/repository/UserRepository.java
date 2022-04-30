package az.developia.springsecuritydemo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springsecuritydemo3.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String>{

}
