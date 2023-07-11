package com.UserAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserAPI.Model.Post;
import com.UserAPI.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping
	public List<Post> findAll() {
		List<Post> post = postService.findAll();
		return post;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable Long id) {
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}
}
