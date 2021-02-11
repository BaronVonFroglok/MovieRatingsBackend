package com.revature.movieRatingApplication.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() { super("Resource not found in the database!");}

    public ResourceNotFoundException(String message) { super(message);}
}
