package com.UserAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserAPI.Model.Commentary;

public interface CommentaryRepository extends JpaRepository<Commentary, Long> {

}
