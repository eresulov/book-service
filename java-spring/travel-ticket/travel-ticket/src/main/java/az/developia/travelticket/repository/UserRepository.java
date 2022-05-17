package az.developia.travelticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.travelticket.model.User;


public interface UserRepository extends JpaRepository<User, String>{

}
