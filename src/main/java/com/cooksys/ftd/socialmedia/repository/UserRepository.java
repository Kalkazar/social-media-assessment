package com.cooksys.ftd.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.ftd.socialmedia.entity.Credentials;
import com.cooksys.ftd.socialmedia.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findUserByCredentialsUsername(String username);
	
	User findUserByCredentials(Credentials credentials);
	
}