package com.joinfaces.project.example.repository;

import com.joinfaces.project.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
