package com.Windir.Pety.controller;

import ch.qos.logback.core.model.Model;
import com.Windir.Pety.model.User;
import com.Windir.Pety.repository.UserRepository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

	private final UserRepository userRepository;

	public UserController(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/register")
	public User registerUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
		// Perform validation and save the user
		final User savedUser = userRepository.save(user);
		return savedUser;
	}
}
