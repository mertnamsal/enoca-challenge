package com.namsalmert.enoca_challange.repository;

import com.namsalmert.enoca_challange.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher,Long> {
    Optional<Teacher> findByNameAndSurname(String name,String surname);
}
