package com.revature.movieRatingApplication.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.movieRatingApplication.models.Movie;

import java.util.Optional;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer> {

    Optional<Movie> findMovieByImbdId(String ImbdId);

    Optional<Movie> findMovieById(Integer id);
}
