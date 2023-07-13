package com.UserAPI.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserAPI.Model.Commentary;
import com.UserAPI.Model.Post;
import com.UserAPI.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public List<Post> findAll() {
		List<Post> posts = postRepository.findAll();
		return posts;
	}

	public Post findById(Long id) {
		Optional<Post> posts = postRepository.findById(id);
		return posts.get();
	}

	public Post getCommentaries(Long id) {
		Post post = findById(id);
		post.getComments();

		return post;

	}

	public Post save(Post post) {
		Post p = new Post(post);
		postRepository.save(p);
		return p;
	}
}
