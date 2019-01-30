package com.regular.todotask.todotask.web;

import com.regular.todotask.todotask.domain.ToDoTask;
import com.regular.todotask.todotask.service.ToDoTasksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ToDoTasksController {

    private final ToDoTasksService service;

    public ToDoTasksController(ToDoTasksService service) {
        this.service = service;
    }

    @GetMapping("/find-all")
    public List<ToDoTask>allTasks(){
        return service.findAllTasks();
    }

    @GetMapping("/find-by-id/{id}")
    public Optional<ToDoTask> toDoTaskById(@PathVariable(value = "id")Long id){
        return service.findTaskById(id);
    }

    @GetMapping("/find-by-status")
    public List<ToDoTask> toDoTaskByStatus(@RequestParam("status") String status){
        return service.findTaskByStatus(status);
    }

    @PostMapping("/register-task/task")
    public ResponseEntity<String> registerTask(@RequestBody ToDoTask task){
        service.saveToDoTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-task")
    public ResponseEntity<String> updateTask(@RequestBody ToDoTask task){
        service.updateToDoTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
