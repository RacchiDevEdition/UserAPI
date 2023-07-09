package com.UserAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserAPI.Model.UserPost;
import com.UserAPI.services.UserPostService;

@RestController
@RequestMapping("/userposts")
public class UserPostController {

	@Autowired
	private UserPostService userPostServices;
	
	@GetMapping
	public List<UserPost> findAll(){
		List<UserPost> userposts = userPostServices.findAll();
		return userposts;
	}
}
