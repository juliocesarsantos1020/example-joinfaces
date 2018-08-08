package com.joinfaces.project.example.controller;

import com.joinfaces.project.example.model.Person;
import com.joinfaces.project.example.model.State;
import com.joinfaces.project.example.service.PersonService;
import com.joinfaces.project.example.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class PersonBean implements Serializable {

    private Person person;
    private List<State> states;
    private List<Person> people;

    @Autowired
    private PersonService personService;
    @Autowired
    private StateService stateService;

    @PostConstruct
    public void init() {
        person = new Person();
        states = stateService.list();
        people = personService.list();
    }

    public void savePerson() {
        personService.savePerson(person);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public StateService getStateService() {
        return stateService;
    }

    public void setStateService(StateService stateService) {
        this.stateService = stateService;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}