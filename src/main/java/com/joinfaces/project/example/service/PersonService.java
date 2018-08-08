package com.joinfaces.project.example.service;

import com.joinfaces.project.example.model.Person;
import com.joinfaces.project.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public List<Person> list() {
        return personRepository.findAll();
    }
}