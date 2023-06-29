package com.example.backTrelloBis.service;

import com.example.backTrelloBis.entity.Task;
import com.example.backTrelloBis.repository.TaskRepository;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTask(){return taskRepository.findAll();}

    public Optional<Task> getTaskById(final ObjectId id_task){return taskRepository.findById(id_task);}

    public Iterable<Task> getTaskByIdUser(final ObjectId id_user){return taskRepository.findByIdUser(id_user);}

    public Iterable<Task> getTaskByIdState(final ObjectId id_state){return taskRepository.findByIdState(id_state);}

    public Optional<Task> getTaskByName(final String task){return taskRepository.findByTask(task);}

    public Optional<ObjectId> getIdUserByTask(final ObjectId id_task) {
        Optional<Task> task = taskRepository.findById(id_task);
        if (task.isPresent()) {
            Task actualTask = task.get();
            if (actualTask.getIdUser() != null) {
                return Optional.of(actualTask.getIdUser());
            }
        }
        return Optional.empty();
    }

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteTask(final ObjectId id_task){
        taskRepository.deleteById(id_task);
    }
}
