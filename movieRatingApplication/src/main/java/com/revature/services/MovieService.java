package com.revature.services;

import com.revature.exceptions.BadRequestException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.Movie;
import com.revature.repos.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    private MovieRepo movieRepo;

    @Autowired
    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public Movie addNewMovie(Movie newMovie){
        if (newMovie.getTitle() == null){
            throw new BadRequestException("The new Movie must have a title!");
        } else if (newMovie.getYear() == null){
            throw new BadRequestException("The new Movie must have a year!");
        } else if (newMovie.getImbdId() == null){
            throw new BadRequestException("The new Movie must have an Imbd Id!");
        }
        Optional<Movie> movie = movieRepo.findMovieByImbdId(newMovie.getImbdId());
        if (movie.isPresent()){
            throw  new ResourcePersistenceException("The Movie: " + newMovie.getTitle() + " already exists in our database!");
        }
        return movieRepo.save(newMovie);
    }
}
