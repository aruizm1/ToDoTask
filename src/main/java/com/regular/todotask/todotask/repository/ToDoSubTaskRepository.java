package com.regular.todotask.todotask.repository;

import com.regular.todotask.todotask.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoSubTaskRepository extends JpaRepository<SubTask,Long> {
}
