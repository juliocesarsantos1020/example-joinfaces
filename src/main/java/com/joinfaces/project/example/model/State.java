package com.joinfaces.project.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idState;
    private String state;

    public Long getIdState() {
        return idState;
    }

    public void setIdState(Long idState) {
        this.idState = idState;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;

        State state = (State) o;

        return getIdState() != null ? getIdState().equals(state.getIdState()) : state.getIdState() == null;
    }

    @Override
    public int hashCode() {
        return getIdState() != null ? getIdState().hashCode() : 0;
    }
}