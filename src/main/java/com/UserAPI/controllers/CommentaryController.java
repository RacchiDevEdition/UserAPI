package com.UserAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Commentary> findAll(){
		List<Commentary> list = commentaryService.findAll();
		return list;
	}
}
