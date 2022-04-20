package az.developia.springcoredemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springcoredemo.model.Ram;

public interface RamRepo extends JpaRepository<Ram, Integer> {

}
