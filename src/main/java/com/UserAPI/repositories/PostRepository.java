package com.UserAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserAPI.Model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
