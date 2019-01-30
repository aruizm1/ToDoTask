package com.regular.todotask.todotask.repository;

import com.regular.todotask.todotask.domain.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoTasksRepository extends JpaRepository<ToDoTask,Long> {
    List<ToDoTask> findByStatus(String status);
}
