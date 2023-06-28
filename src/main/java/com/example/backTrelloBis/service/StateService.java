package com.example.backTrelloBis.service;

import com.example.backTrelloBis.entity.State;
import com.example.backTrelloBis.repository.StateRepository;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class StateService {

    private final StateRepository stateRepository;
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }
    public Iterable<State> getAllState(){return stateRepository.findAll();}
    public Optional<State> getStateById(final ObjectId id_state){return stateRepository.findById(id_state);}
    public State saveState(State state){
        return stateRepository.save(state);
    }
    public void deleteState(final ObjectId id_state){
        stateRepository.deleteById(id_state);
    }

}
