package com.joinfaces.project.example.model;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;
    private String name;
    private Integer age;
    private String email;

    @ManyToOne
    private State state;

    public Person() {
        state = new State();
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return getIdPerson() != null ? getIdPerson().equals(person.getIdPerson()) : person.getIdPerson() == null;
    }

    @Override
    public int hashCode() {
        return getIdPerson() != null ? getIdPerson().hashCode() : 0;
    }
}