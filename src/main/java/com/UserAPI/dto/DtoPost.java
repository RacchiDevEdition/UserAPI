package com.UserAPI.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.UserAPI.Model.Post;
import com.UserAPI.Model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class DtoPost {

	private Long id;
	private DtoUser creator;
	private String content;
	private Instant creationTime;
	@JsonIgnore
	private List<DtoCommentary> comments = new ArrayList<>();


	public DtoPost(Post post) {
		BeanUtils.copyProperties(post, this);

	}

	public DtoPost() {
		

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DtoUser getCreator() {
		return creator;
	}

	public void setCreator(DtoUser creator) {
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
	
}
