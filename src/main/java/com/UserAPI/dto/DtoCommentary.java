package com.UserAPI.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.UserAPI.Model.Commentary;
import com.UserAPI.Model.User;

public class DtoCommentary {

	private DtoUser commentor;
	private DtoPost post;
	private String content;
	private String creationTime;
	private Integer likeCount;

	public DtoCommentary(Commentary commentary) {

		this.commentor = new DtoUser(commentary.getCommentor());
		this.content = commentary.getContent();
		this.post = new DtoPost(commentary.getPost());
		this.content = commentary.getContent();
		this.creationTime = commentary.getCreationTime();
		this.likeCount = commentary.getLikeCount();
	}

	public DtoCommentary() {
	}

	public DtoPost getPost() {
		return post;
	}

	public void setPost(DtoPost post) {
		this.post = post;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public DtoUser getCommentor() {
		return commentor;
	}

	public void setCommentor(DtoUser user) {
		this.commentor = user;
	}
	

}
