package com.revature.movieRatingApplication.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.movieRatingApplication.models.Movie;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer> {

}
