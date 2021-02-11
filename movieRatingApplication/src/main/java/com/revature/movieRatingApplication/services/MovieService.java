package com.revature.movieRatingApplication.services;

import com.revature.movieRatingApplication.models.Movie;
import com.revature.movieRatingApplication.repos.MovieRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepo movieRepo;

    @Autowired
    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }


}
