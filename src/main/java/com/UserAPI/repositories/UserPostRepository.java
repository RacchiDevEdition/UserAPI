package com.UserAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserAPI.Model.UserPost;

public interface UserPostRepository extends JpaRepository<UserPost, Long> {

}
