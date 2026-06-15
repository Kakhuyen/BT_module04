package com.codegym.picture.service;

import com.codegym.picture.model.BadWordException;
import com.codegym.picture.model.Comment;
import com.codegym.picture.repository.ICommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService {

    private final ICommentRepository repository;

    public CommentService(ICommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Comment> findTodayComments() {
        return repository.findAllByCommentDate(LocalDate.now());
    }

    @Override
    public void save(Comment comment) {
        List<String> badWords = Arrays.asList("ngu", "dốt", "fuck", "shit");

        if (comment.getFeedback() != null) {
            String feedback = comment.getFeedback().toLowerCase();
            for (String word : badWords) {
                if (feedback.contains(word)) {
                    throw new BadWordException(comment);
                }
            }
        }

        if (comment.getCommentDate() == null) {
            comment.setCommentDate(LocalDate.now());
        }

        repository.save(comment);
    }

    @Override
    public void like(Long id) {
        Optional<Comment> optionalComment = repository.findById(id);

        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            comment.setLikes(comment.getLikes() + 1);
            repository.save(comment);
        }
    }
}