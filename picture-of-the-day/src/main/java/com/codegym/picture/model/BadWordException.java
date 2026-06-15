package com.codegym.picture.model;

public class BadWordException extends RuntimeException {

    private final Comment comment;

    public BadWordException(Comment comment) {
        super("Feedback contains inappropriate words");
        this.comment = comment;
    }

    public Comment getComment() {
        return comment;
    }
}