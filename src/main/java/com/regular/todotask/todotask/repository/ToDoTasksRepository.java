package com.regular.todotask.todotask.repository;

import com.regular.todotask.todotask.domain.ToDoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@Repository
public interface ToDoTasksRepository extends JpaRepository<ToDoTask,Long> {
    List<ToDoTask> findByStatus(String status);

    @Query("select t from ToDoTask t where t.category = :category")
    List<ToDoTask> findByCategory(@Param("category") String category);

}


