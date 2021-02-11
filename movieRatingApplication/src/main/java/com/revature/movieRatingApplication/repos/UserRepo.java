package com.revature.movieRatingApplication.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.movieRatingApplication.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	Optional<User> findByUsername(String username);
	boolean existsByUsername(String username);
	
}
