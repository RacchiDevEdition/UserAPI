package com.UserAPI.PK;

import java.util.Objects;

import com.UserAPI.Model.Commentary;
import com.UserAPI.Model.Post;
import com.UserAPI.Model.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class PostCommentaryPk {

	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	@ManyToOne
	@JoinColumn(name = "commentary_id")
	private Commentary commentary;
	@ManyToOne
	@JoinColumn(name = "commentor_id")
	private User commentor;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Commentary getCommentary() {
		return commentary;
	}

	public void setCommentary(Commentary commentary) {
		this.commentary = commentary;
	}

	
	public User getCommentor() {
		return commentor;
	}

	public void setCommentor(User commentor) {
		this.commentor = commentor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commentary, post);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostCommentaryPk other = (PostCommentaryPk) obj;
		return Objects.equals(commentary, other.commentary) && Objects.equals(post, other.post);
	}

}
