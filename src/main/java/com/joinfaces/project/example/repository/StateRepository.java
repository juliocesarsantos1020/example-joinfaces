package com.joinfaces.project.example.repository;

import com.joinfaces.project.example.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {

    public State findByIdState(Long id);
}
