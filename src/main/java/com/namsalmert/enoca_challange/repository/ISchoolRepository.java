package com.namsalmert.enoca_challange.repository;

import com.namsalmert.enoca_challange.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISchoolRepository extends JpaRepository<School,Long> {
    Optional<School> findByName(String name);
}
