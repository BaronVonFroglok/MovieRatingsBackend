package com.revature.movieRatingApplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.movieRatingApplication.models.User;
import com.revature.movieRatingApplication.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	private UserService userService;

	BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/login")
	public User loginUser(@RequestBody User user) {
		User current = this.userService.findUserByUsername(user.getUsername());
		if(!(this.userService.existsByUsername(user.getUsername()) && encrypt.matches(user.getPassword(), current.getPassword()))) {
			return null;
		}
		else {
			User currUser = this.userService.findUserByUsername(user.getUsername());
			currUser.setPassword("*****");
			return currUser;
		}
		
		
	}
	
	@PostMapping
    public User addNewUser(@RequestBody User user) {
		user.setPassword(encrypt.encode(user.getPassword()));
		user.setUsername(user.getUsername());
		return this.userService.addUser(user);
	}
	

}
