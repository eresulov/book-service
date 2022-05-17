package az.developia.compshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.compshop.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
