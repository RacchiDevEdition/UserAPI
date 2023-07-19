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

import com.UserAPI.Model.Commentary;
import com.UserAPI.Model.Post;
import com.UserAPI.dto.DtoCommentary;
import com.UserAPI.dto.DtoPost;
import com.UserAPI.services.CommentaryService;
import com.UserAPI.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private CommentaryService commentaryService;

	@GetMapping
	public List<DtoPost> findAll() {
		List<DtoPost> post = postService.findAll();
		return post;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DtoPost> findById(@PathVariable Long id) {
		DtoPost post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}

	@GetMapping(value = "/{id}/comments")
	public List<DtoCommentary> getComments(@PathVariable Long id) {
		DtoCommentary post = commentaryService.findById(id);
		return post.getPost().getComments();
	}

	@PostMapping(value = "/newpost", consumes = { "application/xml", "application/json" })

	public DtoPost newPost(@RequestBody DtoPost newPost) {
		DtoPost p = postService.save(new Post(newPost));
		return p;
	}

}
