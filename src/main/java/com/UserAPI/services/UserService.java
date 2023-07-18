package com.UserAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserAPI.Model.User;
import com.UserAPI.dto.DtoUser;
import com.UserAPI.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	
	public List<DtoUser> findAll() {
		List<User> users = userRepository.findAll();
		List<DtoUser> findAll = users.stream().map(x -> new DtoUser(x)).toList();
		return findAll;
	}

	public DtoUser saveUser(User user) {

		User user1 = userRepository.save(user);
		DtoUser newUser = new DtoUser(user1);
		return newUser;
	}

	public DtoUser FindById(Long id) {
		User user = userRepository.findById(id).get();
		DtoUser findById = new DtoUser(user);
		return findById;
	}
	
	
}