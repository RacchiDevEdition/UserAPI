package com.UserAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserAPI.Model.User;
import com.UserAPI.dto.DtoCommentary;
import com.UserAPI.dto.DtoUser;
import com.UserAPI.services.CommentaryService;
import com.UserAPI.services.UserService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CommentaryService commentaryService;

	@GetMapping
	public List<DtoUser> findAll() {
		List<DtoUser> users = userService.findAll();
		return users;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DtoUser> findById(@PathVariable Long id) {

		DtoUser user = userService.FindById(id);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping(value = "/newuser", consumes = { "application/xml", "application/json" })

	public DtoUser createNewUser(@RequestBody DtoUser user) {
		DtoUser newUser = userService.saveUser(new User(user));
		return newUser;
	}

	@GetMapping(value = "/{id}/comments")
	public ResponseEntity<DtoCommentary> getCommentaries(@PathVariable Long id) {
		DtoCommentary user = commentaryService.getCommentariesByUser(id);
		return ResponseEntity.ok().body(user);

	}
}
