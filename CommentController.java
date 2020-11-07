package com.redink.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redink.app.entities.Comments;
import com.redink.app.exception.ResourceNotFoundException;
import com.redink.app.repository.CommentsRepository;
import com.redink.app.repository.PostRepository;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentsRepository commentRepository;

	@PostMapping("/save/{postId}")
	public Comments createComment(@PathVariable(value = "postId") int postId, @RequestBody Comments comment) {
		return postRepository.findById(postId).map(post -> {
			comment.setPost(post);
			return commentRepository.save(comment);
		}).orElseThrow(() -> new ResourceNotFoundException("postId " + postId + " not found"));
	}

}


