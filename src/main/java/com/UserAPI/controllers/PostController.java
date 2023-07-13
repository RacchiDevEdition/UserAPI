package com.UserAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping(value = "/{id}/comments")
	public Post getCommentaries(@PathVariable Long id) {
		Post post = postService.getCommentaries(id);
		return post;

	}

	@PostMapping(value = "/newpost", consumes = { "application/xml", "application/json" })

	public Post newPost(@RequestBody Post newPost) {
		Post p = postService.save(new Post(newPost));
		return p;
	}

}
