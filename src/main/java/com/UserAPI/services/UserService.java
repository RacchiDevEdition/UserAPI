package com.UserAPI.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserAPI.Model.Commentary;
import com.UserAPI.Model.User;
import com.UserAPI.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public User saveUser(User user) {

		User newUser = new User(user);
		newUser = userRepository.save(newUser);
		return newUser;
	}

	public User FindById(Long id) {
		Optional<User> users = userRepository.findById(id);
		return users.get();
	}

	
	public List<Commentary> getCommentaries(Long id) {
		User user = FindById(id);
		List<Commentary> comments = new ArrayList<>();
		for (Commentary c : comments) {
			comments.add(c);
		}
		return user.getCommentaries();

	}
}