package com.spring.project.jobPortal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.project.jobPortal.entity.Users;
import com.spring.project.jobPortal.services.UsersService;
import com.spring.project.jobPortal.services.UsersTypeService;

import jakarta.validation.Valid;

@Controller
public class UsersController {

	@Autowired
	private UsersTypeService usersTypeService;

	@Autowired
	private UsersService usersService;

	@GetMapping("/register")
	public String register(Model model) {

		model.addAttribute("getAllTypes", usersTypeService.getAllUsersType());
		model.addAttribute("user", new Users());
		return "register";

	}

	@PostMapping("/register/new")
	public String userRegistration(Model model, @Valid Users users) {
		// System.out.println(users);
		Optional<Users> byEmail = usersService.findByEmail(users.getEmail());

		if (byEmail.isPresent()) {
			
			model.addAttribute("error","Email already exists!");
			model.addAttribute("getAllTypes", usersTypeService.getAllUsersType());
			model.addAttribute("user", new Users());
			return "register";
			
		}
		model.addAttribute("users", usersService.addNewUser(users));
		return "dashboard";

	}
}
