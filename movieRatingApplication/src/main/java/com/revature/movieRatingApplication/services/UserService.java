package com.revature.movieRatingApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.movieRatingApplication.models.User;
import com.revature.movieRatingApplication.repos.UserRepo;

@Service
public class UserService {

	private UserRepo userRepo;

	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public User findUserByUsername(String username) {
		return this.userRepo.findByUsername(username).orElseThrow();
	}
	
	public boolean existsByUsername(String username) {
		return this.existsByUsername(username);
	}
	public User addUser(User user) {
		return this.userRepo.save(user);
	}

}
