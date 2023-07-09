package com.UserAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserAPI.Model.PostCommentary;
import com.UserAPI.services.PostCommentaryService;

@RestController
@RequestMapping("/postCommentary")
public class PostCommentaryController {


	@Autowired
	private PostCommentaryService postCommentaryService;
	
	@GetMapping
	public List<PostCommentary> findAll(){
		List<PostCommentary> list = postCommentaryService.findAll();
		return list;
	}
}
