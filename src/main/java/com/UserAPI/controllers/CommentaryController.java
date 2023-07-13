package com.UserAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserAPI.Model.Commentary;
import com.UserAPI.services.CommentaryService;

@RestController
@RequestMapping("/commentaries")
public class CommentaryController {

	@Autowired
	private CommentaryService commentaryService;

	@GetMapping
	public List<Commentary> findAll() {
		List<Commentary> list = commentaryService.findAll();
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public Commentary findById(@PathVariable Long id) {
		Commentary comment = commentaryService.findById(id);
		return comment;
		
	}

	@GetMapping(value = "/mostliked")
	public Commentary findMostLiked() {
		Commentary mostLiked = commentaryService.findMostLiked();
		return mostLiked;
	}

	@PostMapping(value = "/newcommentary", consumes = { "application/xml", "application/json" })
	public Commentary newCommentary(@RequestBody Commentary comment) {
		Commentary newCommentary = commentaryService.save(comment);
		return newCommentary;
	}

	@GetMapping(value = "/{id}/givelike")
	public Commentary giveLike(@PathVariable Long id) {
		Commentary comment = commentaryService.giveLike(id);
		return comment;
	}
}
