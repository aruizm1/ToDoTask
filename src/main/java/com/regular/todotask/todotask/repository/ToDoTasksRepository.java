package com.regular.todotask.todotask.repository;

import com.regular.todotask.todotask.domain.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoTasksRepository extends JpaRepository<ToDoTask,Long> {
    List<ToDoTask> findByStatus(String status);
}
