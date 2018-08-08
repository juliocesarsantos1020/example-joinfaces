package com.joinfaces.project.example.service;

import com.joinfaces.project.example.model.State;
import com.joinfaces.project.example.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public void saveState(State state) {
        stateRepository.save(state);
    }

    public List<State> list() {
        return stateRepository.findAll();
    }

    public Optional<State> findByIdState(Long idState){
        return stateRepository.findById(idState);
    }
}