package com.revature.exceptions;

public class BadRequestException extends RuntimeException{

    public BadRequestException() { super("A Bad Request Exception has occurred!");}

    public BadRequestException(String message) { super(message); }
}
