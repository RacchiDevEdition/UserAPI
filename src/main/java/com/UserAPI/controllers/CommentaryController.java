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
import com.UserAPI.dto.DtoCommentary;
import com.UserAPI.services.CommentaryService;

@RestController
@RequestMapping("/commentaries")
public class CommentaryController {

	@Autowired
	private CommentaryService commentaryService;

	@GetMapping
	public List<DtoCommentary> findAll() {
		List<DtoCommentary> list = commentaryService.findAll();
		return list;
	}

	@GetMapping(value = "/{id}")
	public DtoCommentary findById(@PathVariable Long id) {
		DtoCommentary comment = commentaryService.findById(id);
		return comment;

	}

	@GetMapping(value = "/mostliked")
	public DtoCommentary findMostLiked() {
		DtoCommentary mostLiked = commentaryService.findMostLiked();
		return mostLiked;
	}

	@PostMapping(value = "/newcommentary", consumes = { "application/xml", "application/json" })
	public DtoCommentary newCommentary(@RequestBody DtoCommentary comment) {
		DtoCommentary newCommentary = commentaryService.save(new Commentary(comment));
		return newCommentary;
	}

	@PostMapping(value = "/{id}/givelike")
	public DtoCommentary giveLike(@PathVariable Long id) {
		DtoCommentary comment = commentaryService.giveLike(id);
		return comment;
	}
}
