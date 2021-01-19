package com.hcl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.dao.TaskRepository;
import com.hcl.dao.UserRepository;
import com.hcl.model.Task;
import com.hcl.model.User;

@Controller
public class TaskController {

	@Autowired
	private TaskRepository taskDao;

	@Autowired
	private UserRepository userDao;

	@GetMapping("/task/{userEmail}/all-tasks")
	public ModelAndView getAllTasks(@PathVariable String userEmail) {
		List<Task> allTasks = taskDao.findAll();
		List<Task> taskList = new ArrayList<>();
		for (Task task : allTasks) {
			if (task.getUser().getUserEmail().equals(userEmail)) {
				taskList.add(task);
			}
		}
		return new ModelAndView("dashboard", "taskList", taskList);
	}

	@GetMapping("/task/{taskId}/update-task/{userEmail}")
	public ModelAndView getUpdateForm(@PathVariable String taskId, @PathVariable String userEmail) {
		Long convertedTaskId = Long.parseLong(taskId);
		Task task = taskDao.getOne(convertedTaskId);
		return new ModelAndView("taskform", "newTask", task);
	}

	@PostMapping("/task/{taskId}/update-task/{userEmail}")
	public String updateTask(@PathVariable String taskId, @PathVariable String userEmail, Task task) {
		Long convertedTaskId = Long.parseLong(taskId);
		User currentUser = userDao.getOne(userEmail);
		task.setUser(currentUser);
		task.setId(convertedTaskId);
		task = taskDao.saveAndFlush(task);
		return "redirect:/task/" + task.getUser().getUserEmail() + "/all-tasks";
	}

	@GetMapping("/task/{taskId}/delete-task/{userEmail}")
	public String deleteTask(@PathVariable String taskId, @PathVariable String userEmail) {
		Long convertedTaskId = Long.parseLong(taskId);
		taskDao.deleteById(convertedTaskId);
		return "redirect:/task/" + userEmail + "/all-tasks";
	}

}