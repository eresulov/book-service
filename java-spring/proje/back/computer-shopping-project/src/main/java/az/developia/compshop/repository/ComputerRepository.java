package az.developia.compshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.compshop.model.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {

	@Query(value = "select * from computer where username=?1", nativeQuery = true)
	List<Computer> findAllByUsername(String username);

}
