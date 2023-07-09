package com.UserAPI.Model;

import java.util.Objects;

import com.UserAPI.PK.PostCommentaryPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_post_commentary")
public class PostCommentary {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private PostCommentaryPk id = new PostCommentaryPk();
	
	public PostCommentary(User commentor, Post post, Commentary commentary) {
		id.setCommentor(commentor);
		id.setPost(post);
		id.setCommentary(commentary);
		
	}
	
	public PostCommentary() {
		
	}

	public PostCommentaryPk getId() {
		return id;
	}

	@JsonIgnore
	public User getCommentor() {
		return id.getCommentor(); 
	}
	
	public void setCommentor(User commentor) {
		id.setCommentor(commentor);
	}
	
	@JsonIgnore
	public Post getPost() {
		return id.getPost();
	}
	
	public void setPost(Post post) {
		id.setPost(post);
	}
	
	public Commentary getCommentary() {
		return id.getCommentary();
	}
	
	public void setCommentary(Commentary commentary) {
		id.setCommentary(commentary);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostCommentary other = (PostCommentary) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
