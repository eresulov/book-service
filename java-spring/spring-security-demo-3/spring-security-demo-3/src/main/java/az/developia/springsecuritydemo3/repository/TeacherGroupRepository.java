package az.developia.springsecuritydemo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springsecuritydemo3.model.TeacherGroup;

public interface TeacherGroupRepository extends JpaRepository<TeacherGroup, Integer>{

}
