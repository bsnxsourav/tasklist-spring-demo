package com.bsn.tasklist.backend.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bsn.tasklist.backend.model.Task;
import com.bsn.tasklist.backend.service.TaskService;

@RestController
public class MainController {
	private Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/check")
	public String testMethod() {
		return "Working";
	}
	
	@RequestMapping("/tasks")
	public Iterable<Task> tasks() {
		return taskService.getAllTasks();
	}
	
	@RequestMapping("/task/{id}")
	public Task taskById(@PathVariable Long id) {
		return taskService.getTaskbyId(id).get();
	}
	
	@RequestMapping(value = "/tasks", method = RequestMethod.POST)
	public ResponseEntity<Object> addTask(@RequestBody Task task) {
		Task savedTask = taskService.addTask(task);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTask.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
