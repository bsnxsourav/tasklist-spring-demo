package com.bsn.tasklist.backend.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsn.tasklist.backend.model.Task;
import com.bsn.tasklist.backend.repository.TaskRepository;


@Service
public class TaskService {
	private Logger logger = LoggerFactory.getLogger(TaskService.class);
	
	@Autowired
	private TaskRepository taskRepository;
	
	public Iterable<Task> getAllTasks() {
		return taskRepository.findAll();
	}
	
	public Optional<Task> getTaskbyId(Long id) {
		return taskRepository.findById(id);
	}
	
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}
	
}
