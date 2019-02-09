package com.regular.todotask.todotask.web;

import com.regular.todotask.todotask.domain.SubTask;
import com.regular.todotask.todotask.service.ToDoSubTasksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoSubTasksController {
    private final ToDoSubTasksService service;

    public TodoSubTasksController(ToDoSubTasksService service) {this.service = service; }


    @GetMapping("/all-subtask")
    public List<SubTask> allSubTasks() {
        return service.findAllSubTaskTasks();
    }

    @PostMapping("/register-subtask")
    public ResponseEntity<String> registerSubTask(@RequestBody SubTask subtask) {
        service.saveToDoSubTask(subtask);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-subtask")
    public ResponseEntity<String> updateSubTask(@RequestBody SubTask subtask) {
        service.updateToDoSubTask(subtask);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
