package com.UserAPI.dto;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.UserAPI.Model.Commentary;


public class DtoCommentary {

	private DtoUser commentor;
	private DtoPost post;
	private String content;
	private String creationTime;
	private Integer likeCount;	
	
	private static List<Commentary> commentaries = new ArrayList<>();
	


	public DtoCommentary(Commentary commentary) {
		BeanUtils.copyProperties(commentary, this);
		commentaries.add(commentary);
	}
	
	
	public DtoCommentary() {}


	public DtoUser getCommentor() {
		return commentor;
	}

	public void setCommentor(DtoUser commentor) {
		this.commentor = commentor;
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


	public List<Commentary> getCommentaries() {
		return commentaries;
	}	
	
	public static List<DtoCommentary> convert(List<Commentary> topicos) {
	    List<DtoCommentary> dtos = new ArrayList<>();

	    for(Commentary comment : commentaries) {
	        DtoCommentary dto = new DtoCommentary(comment);

	        dtos.add(dto);
	    }

	    return dtos;
	}
	
	


}
