package com.UserAPI.PK;

import java.util.Objects;

import com.UserAPI.Model.Post;
import com.UserAPI.Model.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;

@Embeddable
public class UserPostPk {

	@OneToOne
	private User creator;

	@OneToOne
	private Post post;

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creator, post);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPostPk other = (UserPostPk) obj;
		return Objects.equals(creator, other.creator) && Objects.equals(post, other.post);
	}

}
