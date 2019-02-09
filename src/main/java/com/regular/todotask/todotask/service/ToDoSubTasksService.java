package com.regular.todotask.todotask.service;

import com.regular.todotask.todotask.domain.SubTask;
import com.regular.todotask.todotask.repository.ToDoSubTaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ToDoSubTasksService {
    private final ToDoSubTaskRepository repository;


    public ToDoSubTasksService(ToDoSubTaskRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<SubTask> findAllSubTaskTasks(){
        return repository.findAll();
    }

    @Transactional
    public void saveToDoSubTask(SubTask subtask){
        repository.saveAndFlush(subtask);
    }

    @Transactional
    public void updateToDoSubTask(SubTask subtask){
        Optional<SubTask> todosubtask = repository.findById(subtask.getId());
        SubTask tempTask = todosubtask.get();
        subtask.setId(tempTask.getId());
        repository.saveAndFlush(subtask);
    }

}
