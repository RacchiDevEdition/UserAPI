package com.UserAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

		User newUser = new User();
		newUser = userRepository.save(newUser);
		return newUser;
	}
}
