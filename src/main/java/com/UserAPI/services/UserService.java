package com.UserAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserAPI.Model.Commentary;
import com.UserAPI.Model.User;
import com.UserAPI.dto.DtoCommentary;
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
	
	

	public DtoUser getCommentaries(Long id) {
		DtoUser user = FindById(id);
		List<DtoCommentary> comments = user.getCommentaries();
		DtoUser u2 = comments.get(0).getCommentor();
		return u2; 

	}
}