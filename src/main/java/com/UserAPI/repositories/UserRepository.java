package com.UserAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserAPI.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
