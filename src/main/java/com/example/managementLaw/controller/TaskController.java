package com.example.managementLaw.controller;

import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.managementLaw.Entity.Task;
import com.example.managementLaw.Service.TaskService;
import com.example.managementLaw.Service.TaskServiceImpl;

import jakarta.validation.Valid;

@Controller
public class TaskController {
	private TaskService TaskService;

	public TaskController(TaskService TaskService) {
		super();
		this.TaskService = TaskService;
	}

	@GetMapping("/tasks")
	public String listtasks(Model model) {
		model.addAttribute("tasks", TaskService.getAllTasks());
		return "tasks";
	}
	
	@GetMapping("/tasks/new")
	public String createTaskForm(Model model) {
		
		// create student object to hold student form data
		Task task = new Task();
		model.addAttribute("task", task);
		return "create_task";
		
	}
	
	/**@PostMapping("/tasks")
	public String saveTask( @ModelAttribute("Task") Task Task) {
	   TaskServiceImpl.sendEmailToAdmin(Task);

       
		TaskService.saveTask(Task);
		return "redirect:/tasks";
	}
	*/
	@GetMapping("/tasks/edit/{id}")
	public String editTaskForm(@PathVariable Long id, Model model) {
		model.addAttribute("task", TaskService.getTaskById(id));
		return "edit_task";
	}

	@PostMapping("/tasks/{id}")
	public String  updateTask(@PathVariable Long id,
			@ModelAttribute("task") Task task,BindingResult result,
			Model model) {
		
		// get student from database by id
		
		 
	    	Task s = TaskService.getTaskById(id);
	       
	
		s.setId(id);
		s.setTitre(task.getTitre());
		s.setDescription(task.getDescription());
		s.setStatus(task.getStatus());
		s.setDateC(task.getDateC());
		s.setDateT(task.getDateT());
		
		// save updated student object
		TaskService.updateTask(s);
		return "redirect:/tasks";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/tasks/{id}")
	public String delete(@PathVariable Long id) {
		TaskService.deleteTaskById(id);
		return "redirect:/tasks";
	}
	
}

