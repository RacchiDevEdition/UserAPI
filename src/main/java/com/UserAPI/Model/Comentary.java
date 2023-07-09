package com.UserAPI.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_comentary")
public class Comentary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_creatorC")
	private User creatorC;
	private String content;
	private Integer likeCount;

	public Comentary(Long id, User creatorC, String content, Integer likeCount) {
		super();
		this.id = id;
		this.creatorC = creatorC;
		this.content = content;
		this.likeCount = likeCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreatorC() {
		return creatorC;
	}

	public void setCreatorC(User creatorC) {
		this.creatorC = creatorC;
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

}
