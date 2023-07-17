package com.UserAPI.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.UserAPI.Model.Post;
import com.UserAPI.Model.User;

public class DtoPost {

	private Long id;
	private User creator;
	private String content;
	private Instant creationTime;
	private List<DtoCommentary> comments = new ArrayList<>();
	private List<Post> posts = new ArrayList<>();


	public DtoPost(Post post) {
		BeanUtils.copyProperties(post, this);
		posts.add(post);
	}

	public DtoPost() {
		

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Instant getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Instant creationTime) {
		this.creationTime = creationTime;
	}

	public List<DtoCommentary> getComments() {
		return comments;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

}
