package com.cooksys.ftd.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.socialmedia.service.ValidateService;

@RestController
public class ValidateController {
	
	private ValidateService validateService;
	
	@Autowired
	public ValidateController(ValidateService validateService) {
		super();
		this.validateService = validateService;
	}
	
	//@GetMapping("validate/tag/exists/{label}")
	
	@GetMapping("validate/username/available/@{username}")
	public boolean usernameAvailable(@PathVariable("username") String username) {
		return !this.validateService.usernameExists(username);
	}
	
	@GetMapping("validate/username/exists/@{username}")
	public boolean usernameExists(@PathVariable("username") String username) {
		return this.validateService.usernameExists(username);
	}
	
}
