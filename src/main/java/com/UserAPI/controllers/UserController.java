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
import com.UserAPI.Model.User;
import com.UserAPI.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public List<User> findAll() {
		List<User> users = service.findAll();
		return users;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {

		User user = service.FindById(id);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping(value = "/newuser", consumes = { "application/xml", "application/json" })

	public User createNewUser(@RequestBody User user) {
		User newUser = service.saveUser(new User(user));
		return newUser;
	}
	
	
	@GetMapping(value = "/{id}/comments")
	public List<Commentary> getCommentaries(@PathVariable Long id){
		List<Commentary> user  = service.getCommentaries(id);
		return user;
	}
}
