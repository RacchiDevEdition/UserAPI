package com.UserAPI.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
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

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "commentor_id")
	private User commentor;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	private String content;
	private Integer likeCount;

	public Commentary(Long id, User commentor,Post post, String content, Integer likeCount) {
		super();
		this.id = id;
		this.commentor = commentor;
		this.post = post;
		this.content = content;
		this.likeCount = likeCount;
	}
	
	
	public Commentary() {
		
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

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	@Override
	public String toString() {
		return "Commentary [id=" + id + ", commentor=" + commentor + ", post=" + post + ", content=" + content
				+ ", likeCount=" + likeCount + "]";
	}
	
	

}
