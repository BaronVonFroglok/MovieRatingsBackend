package com.revature.movieRatingApplication.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.movieRatingApplication.models.User;
import com.revature.movieRatingApplication.repos.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	UserRepo userRepo;

	@Autowired
	public UserDetailsServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user = userRepo.findByUsername(username);

		return user.map(MyUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("Could not find username: '" + username + "'"));
	}

}
