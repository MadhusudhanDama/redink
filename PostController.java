package com.redink.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redink.app.entities.Posts;
import com.redink.app.repository.PostRepository;

@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostRepository repo;
	
	@PostMapping("/save")
	public Posts savePost(@RequestBody Posts post) {
		return repo.save(post);
	}
	
	
	
}
