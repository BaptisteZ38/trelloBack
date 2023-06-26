package com.example.backTrelloBis.controller;

import com.example.backTrelloBis.entity.Task;
import com.example.backTrelloBis.service.TaskService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("task")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping()
    public Iterable<Task> getAllTask(){return taskService.getAllTask();}

    @GetMapping("/{id_task}")
    public Optional<Task> getTaskById(@PathVariable final ObjectId id_task){return taskService.getTaskById(id_task);}

    @GetMapping("/{task}")
    public Optional<Task> getTaskByName(@RequestParam(value="task")  final String task){return taskService.getTaskByName(task);}

    @GetMapping("/task/{id_task}")
    public Optional<ObjectId> getIdUserByTask(@PathVariable final ObjectId id_task){return taskService.getIdUserByTask(id_task);}

    @GetMapping("/user/{id_user}")
    public Iterable<Task> getTaskByIdUser(@PathVariable final ObjectId id_user){return taskService.getTaskByIdUser(id_user);}

    @GetMapping("/state/{id_state}")
    public Iterable<Task> getTaskByIdState(@PathVariable final ObjectId id_state){return taskService.getTaskByIdState(id_state);}

    @PostMapping("")
    public Task createTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @PutMapping("/{id_task}")
    public Task updateTask(@PathVariable("id_task") final ObjectId id_task, @RequestBody Task task){
        Optional<Task> taskToUpdate = taskService.getTaskById(id_task);
        if(taskToUpdate.isPresent()){
            Task currentTask = taskToUpdate.get();

            String task1 = task.getTask();
            ObjectId idUser = task.getIdUser();
            ObjectId idState = task.getIdState();

            if(task1 != null){
                currentTask.setTask(task1);
            }
            if(idUser != null){
                currentTask.setIdUser(idUser);
            }
            if(idState!=null){
                currentTask.setIdState(idState);
            }
            taskService.saveTask(currentTask);
            return currentTask;
        }else {
            return null;
        }
    }

    @DeleteMapping("/{id_task}")
    public void deleteTask(@PathVariable("id_task") final ObjectId id_task){
        taskService.deleteTask(id_task);
    }
}
