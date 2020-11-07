package com.redink.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redink.app.entities.Authors;
import com.redink.app.exception.ResourceNotFoundException;
import com.redink.app.repository.AuthorRepository;
import com.redink.app.repository.PostRepository;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepo;

	@Autowired
	private PostRepository repo;

	@RequestMapping("/getall")
	public List<Authors> getAll() {
		return authorRepo.findAll();
	}

	@PostMapping("/save/{postId}")
	public Authors saveAuthor(@PathVariable(value = "postId") int postId, @RequestBody Authors author) {
		return repo.findById(postId).map(post -> {
			author.setPost(post);
			return authorRepo.save(author);
		}).orElseThrow(() -> new ResourceNotFoundException("postId " + postId + " not found"));
	}
}
