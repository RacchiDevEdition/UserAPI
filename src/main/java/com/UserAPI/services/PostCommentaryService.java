package com.UserAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserAPI.Model.PostCommentary;
import com.UserAPI.repositories.PostCommentaryRepository;

@Service
public class PostCommentaryService {

	@Autowired
	private PostCommentaryRepository postCommentaryRepository;
	
	public List<PostCommentary> findAll(){
		List<PostCommentary> list = postCommentaryRepository.findAll();
		return list;
	}
}
