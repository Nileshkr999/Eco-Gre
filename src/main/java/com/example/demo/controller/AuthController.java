package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@Controller
public class AuthController {

	@Autowired
	UserService userService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = { "/india" }, method = RequestMethod.GET)
	public String india() {
		return "india";
	}

	@RequestMapping(value = { "/states" }, method = RequestMethod.GET)
	public String states() {
		return "states";
	}

	@RequestMapping(value = { "/world" }, method = RequestMethod.GET)
	public String world() {
		return "world";
	}

	@RequestMapping(value = { "/dashboard" })
	public String deshboard() {
		return "admin/dashboard";
	}

	// @RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	@PostMapping("/register")
	public String registerUser(Model model, @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("successMessage", "User registered successfully!");
			model.addAttribute("bindingResult", bindingResult);
			return "register";
		}
		List<Object> userPresentObj = userService.isUserPresent(user);
		if ((Boolean) userPresentObj.get(0)) {
			model.addAttribute("successMessage", userPresentObj.get(1));
			return "register";
		}

		userService.saveUser(user);
		model.addAttribute("successMessage", "User registered successfully!");

		return "login";
	}
}
