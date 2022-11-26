package com.bsn.tasklist.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bsn.tasklist.backend.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

}
