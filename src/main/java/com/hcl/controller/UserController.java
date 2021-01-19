package com.hcl.controller;

import java.util.Set;

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
public class UserController {

	@Autowired
	private UserRepository userDao;

	@Autowired
	private TaskRepository taskDao;

	static String currentUserEmail = "";

	@GetMapping("/register")
	public ModelAndView register() {
		User newUser = new User();
		return new ModelAndView("registerform", "newUser", newUser);
	}

	@PostMapping("/register")
	public String register(User user) {
		
		ModelAndView mv = new ModelAndView("welcome");
		
		if (userDao.existsById(user.getUserEmail())) {
			String errorMessage = "An account already exists for that email!";
			return "redirect:/error/" + errorMessage;
		} else {
			currentUserEmail = user.getUserEmail();
			userDao.save(user);
			mv.addObject("user", user);
		}
		
		return "redirect:/task/" + currentUserEmail + "/all-tasks";
	}

	@GetMapping("/login")
	public ModelAndView login() {
		User user = new User();
		return new ModelAndView("loginform", "user", user);
	}

	@PostMapping("/login")
	public String login(User login) {
		String errorMessage = "Incorrect Username or Password";
		ModelAndView mv = new ModelAndView("dashboard");
		if (!userDao.existsById(login.getUserEmail())) {
			return "redirect:/error/" + errorMessage;
		} else {
			User user = userDao.getOne(login.getUserEmail());
			if (!user.getPassword().equals(login.getPassword())) {

				return "redirect:/error/" + errorMessage;
			} else {
				currentUserEmail = login.getUserEmail();
				mv.addObject("user", user);
			}
		}
		return "redirect:/task/" + currentUserEmail + "/all-tasks";
	}

	@GetMapping("/user/add-task")
	public ModelAndView addTask() {
		Task newTask = new Task();
		return new ModelAndView("taskform", "newTask", newTask);

	}

	@PostMapping("/user/add-task")
	public String addTask(Task newTask) {

		if (!userDao.existsById(currentUserEmail)) {
			String message = "user doesn't exist";
			return "redirect:/error/" + message;

		}
		User user = userDao.getOne(currentUserEmail);

		newTask.setUser(user);

		newTask = taskDao.save(newTask);

		return "redirect:/task/" + currentUserEmail + "/all-tasks";

	}

	@GetMapping("/logout")
	public String logout() {
		currentUserEmail = "";
		return "redirect:/";
	}

	@GetMapping("/error/{message}")
	public ModelAndView error(@PathVariable String message) {
		return new ModelAndView("error", "message", message);
	}

}
