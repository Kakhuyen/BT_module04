package com.codegym.picture.service;

import com.codegym.picture.model.Comment;

import java.util.List;

public interface ICommentService {

    List<Comment> findTodayComments();

    void save(Comment comment);

    void like(Long id);
}