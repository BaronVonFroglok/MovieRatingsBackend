package com.revature.movieRatingApplication.controllers;

import com.revature.movieRatingApplication.exceptions.BadRequestException;
import com.revature.movieRatingApplication.models.Movie;
import com.revature.movieRatingApplication.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Movie addNewMovie(@RequestBody Movie newMovie){
        return movieService.addNewMovie(newMovie);
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovieById(@PathVariable Integer id){

        return movieService.getMovieById(id);
    }
}
