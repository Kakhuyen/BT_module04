package com.codegym.picture.controller;

import com.codegym.picture.model.Comment;
import com.codegym.picture.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PictureController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", commentService.findTodayComments());
        return "index";
    }

    @PostMapping("/comment")
    public String saveComment(@ModelAttribute Comment comment) {
        commentService.save(comment);
        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") Long id) {
        commentService.like(id);
        return "redirect:/";
    }
}