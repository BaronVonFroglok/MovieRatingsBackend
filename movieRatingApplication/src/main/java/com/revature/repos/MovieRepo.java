package com.revature.repos;

import com.revature.models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer> {

    Optional<Movie> findMovieByImbdId(String imbdId);
}
