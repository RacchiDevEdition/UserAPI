
package com.UserAPI.Model;

import java.io.Serializable;

import com.UserAPI.PK.UserPostPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user_post")
public class UserPost implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UserPostPk id = new UserPostPk();

	public UserPost(Post post, User user) {
		super();
		id.setPost(post);
		id.setCreator(user);
	}

	public UserPost() {

	}

	@JsonIgnore
	public Post getPost() {
		return id.getPost();
	}

	@JsonIgnore
	public User getCreator() {
		return id.getCreator();
	}

	public void setPost(Post post) {
		id.setPost(post);
	}

	public void setCreator(User creator) {
		id.setCreator(creator);
	}

	@Override
	public String toString() {
		return "UserPost [id=" + id + "post ="  + id.getPost() + "creator=" + id.getCreator() + "]";
	}
	
	
	

}
