package com.regular.todotask.todotask.service;

import com.regular.todotask.todotask.domain.ToDoTask;
import com.regular.todotask.todotask.repository.ToDoTasksRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ToDoTasksService {

    private final ToDoTasksRepository repository;


    public ToDoTasksService(ToDoTasksRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ToDoTask> findAllTasks(){
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<ToDoTask> findTaskById(Long id){return  repository.findById(id);}

    @Transactional(readOnly = true)
    public List<ToDoTask> findTaskByStatus(String status){return repository.findByStatus(status);}

    @Transactional
    public void saveToDoTask(ToDoTask task){
        repository.saveAndFlush(task);
    }

    @Transactional
    public void updateToDoTask(Long id, ToDoTask task){
        Optional<ToDoTask> todotask = repository.findById(id);
        ToDoTask tempTask = todotask.get();
        tempTask.setCategory(task.getCategory());
        tempTask.setCreateDate(task.getCreateDate());
        tempTask.setDescription(task.getDescription());
        tempTask.setStatus(task.getStatus());
        repository.saveAndFlush(tempTask);

    }

}

