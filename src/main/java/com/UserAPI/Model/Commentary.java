package com.UserAPI.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.UserAPI.dto.DtoCommentary;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_commentary")
public class Commentary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "commentor_id")
	private User commentor;

	
	
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;
	private String content;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private String creationTime;
	private Integer likeCount;
	

	public Commentary(Long id, User commentor, Post post, String content, String creationTime, Integer likeCount) {
		super();
		this.id = id;
		this.commentor = commentor;
		this.post = post;
		this.creationTime = creationTime;
		this.content = content;
		this.likeCount = likeCount;
	}

	public Commentary() {

	}

	public Commentary(DtoCommentary commentary) {

		commentary.getContent();
		commentary.getCreationTime();
		commentary.getCommentor();
		commentary.getPost();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreator() {
		return commentor;
	}

	public void setCreatorC(User commentor) {
		this.commentor = commentor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public User getCommentor() {
		return commentor;
	}

	public void setCommentor(User commentor) {
		this.commentor = commentor;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}


	public Integer incrementLike() {
		return likeCount + 1;
	}

	@Override
	public String toString() {
		return "Commentary [id=" + id + ", commentor=" + commentor + ", post=" + post + ", content=" + content
				+ ", likeCount=" + likeCount + "]";
	}
}
