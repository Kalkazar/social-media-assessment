package com.cooksys.ftd.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.ftd.socialmedia.repository.UserRepository;

@Service
public class ValidateService {
	
	private UserRepository userRepository;
	//TODO: import repository for tags
	
	@Autowired
	public ValidateService(UserRepository userRepository) {// TODO: add field for tagRepository
		super();
		this.userRepository = userRepository;
		// TODO: add field for tagRepository
	}
	
	public boolean usernameExists(String username) {
		return this.userRepository.findUserByCredentialsUsername(username) != null;
	}
	
	//TODO: method that returns whether a tag exists
}
