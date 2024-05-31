package com.tutorial.exception;

public class TutorialNotFoundException extends RuntimeException {
    public TutorialNotFoundException(Integer id) {
        super("Tutorial NOT Found With ID : " + id);
    }
    
    public TutorialNotFoundException(String message) {
        super(message);
    }
}
