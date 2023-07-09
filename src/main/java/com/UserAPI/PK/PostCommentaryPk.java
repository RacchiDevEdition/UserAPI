package com.UserAPI.PK;

import com.UserAPI.Model.Commentary;
import com.UserAPI.Model.Post;

import jakarta.persistence.Embeddable;

@Embeddable
public class PostCommentaryPk {
	
	private Post post;
	private Commentary commentary;

}
