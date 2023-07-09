package com.UserAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserAPI.Model.UserPost;
import com.UserAPI.repositories.UserPostRepository;

@Service
public class UserPostService {

	@Autowired
	private UserPostRepository userPostRepository;

	public List<UserPost> findAll() {
		List<UserPost> userPosts = userPostRepository.findAll();
		return userPosts;
	}

}
