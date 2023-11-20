package com.example.managementLaw.Service;

import java.util.List;

import com.example.managementLaw.Entity.Task;

public interface TaskService {
List<Task> getAllTasks();
	
Task saveTask(Task task);
	
Task getTaskById(Long id);
	
Task updateTask(Task task);
	
	void deleteTaskById(Long id);
}
