package com.revature.exceptions;

public class ResourcePersistenceException extends RuntimeException{

    public ResourcePersistenceException(){ super("A Resource Persistence Exception has occurred!");}

    public ResourcePersistenceException(String message){ super(message);}
}
