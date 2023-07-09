package com.UserAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserAPI.Model.PostCommentary;

public interface PostCommentaryRepository extends JpaRepository<PostCommentary, Long> {

}
