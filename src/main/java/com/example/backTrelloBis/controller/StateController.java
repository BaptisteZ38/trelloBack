package com.example.backTrelloBis.controller;

import com.example.backTrelloBis.entity.State;
import com.example.backTrelloBis.entity.Task;
import com.example.backTrelloBis.service.StateService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("state")
@CrossOrigin(origins = "http://localhost:4200")
public class StateController {

    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }
    @GetMapping()
    public Iterable<State> getAllState(){return stateService.getAllState();}
    @GetMapping("/{id_state}")
    public Optional<State> getStateById(@PathVariable final ObjectId id_state){return stateService.getStateById(id_state);}

    @PostMapping()
    public State createState(@RequestBody State state){
        return stateService.saveState(state);
    }

    @DeleteMapping("/{id_state}")
    public void deleteState(@PathVariable final ObjectId id_state){
        stateService.deleteState(id_state);
    }
}
