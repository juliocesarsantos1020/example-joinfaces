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

    public State findByIdState(Long idState) {
        Optional<State> state = stateRepository.findById(idState);
        State stateSelecionado = new State();

        if (state.isPresent()) {
            stateSelecionado = state.get();
        }
        return stateSelecionado;
    }
}