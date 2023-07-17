package com.UserAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserAPI.Model.Post;
import com.UserAPI.dto.DtoCommentary;
import com.UserAPI.dto.DtoPost;
import com.UserAPI.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public List<DtoPost> findAll() {
		List<Post> posts = postRepository.findAll();
		List<DtoPost> dtoPosts = posts.stream().map(x -> new DtoPost(x)).toList();
		return dtoPosts;
	}

	public DtoPost findById(Long id) {
		Post posts = postRepository.findById(id).get();
		DtoPost findById = new DtoPost(posts);
		return findById;
	}

	public List<DtoCommentary> getCommentaries(Long id) {
		DtoPost post = findById(id);
		List<DtoCommentary> dto = post.getComments();
		return dto;
	}

	public DtoPost save(Post dtoPost) {
		Post p = postRepository.save(dtoPost);
		DtoPost newPost = new DtoPost(p);
		return newPost;
	}
}
