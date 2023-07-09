
package com.UserAPI.Model;

import java.io.Serializable;

import com.UserAPI.PK.UserPostPk;

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
	private UserPostPk id;

	public UserPost(Post post, User user) {
		id.setPost(post);
		id.setCreator(user);
	}

	public Post getPost() {
		return id.getPost();
	}

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
		return "UserPost [id=" + id + "]";
	}

}
