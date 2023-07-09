package com.UserAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserAPI.Model.Commentary;
import com.UserAPI.repositories.CommentaryRepository;

@Service
public class CommentaryService {

	@Autowired
	private CommentaryRepository commentaryRepository;
	
	public List<Commentary> findAll(){
		 List<Commentary> commentaries = commentaryRepository.findAll();
		 return commentaries;
	}
}
