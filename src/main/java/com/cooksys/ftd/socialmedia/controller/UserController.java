package com.cooksys.ftd.socialmedia.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.socialmedia.dto.CredentialsDto;
import com.cooksys.ftd.socialmedia.dto.UserRequestDto;
import com.cooksys.ftd.socialmedia.dto.UserResponseDto;
import com.cooksys.ftd.socialmedia.service.UserService;

@RestController
public class UserController {// works with DTOs, not entities
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("user")
    public List<UserResponseDto> getAllUsers() {
        return this.userService.getAllUsers();
    }
	
	@PostMapping("user")
    public UserResponseDto saveUser(@RequestBody UserRequestDto user) { // THIS SHOULDN'T OVERWRITE STUFF
        return this.userService.saveUser(user);
    }
	
	@GetMapping("user/@{username}")
	public UserResponseDto getUser(@PathVariable("username") String username) { // path variable necessary?
		return this.userService.getUser(username);
	}
	
	@PatchMapping("user/@{username}")
	public UserResponseDto editUser(@PathVariable("username") String username, @RequestBody UserRequestDto user) {
		return this.userService.editUser(username, user);
	}
	
	@DeleteMapping("user/@{username}")
	public UserResponseDto deleteUser(@PathVariable("username") String username, @RequestBody CredentialsDto credentialsDto) {
		return this.userService.deleteUser(username, credentialsDto);
	}
	
	@PostMapping("user/@{username}/follow")
	public void followUser(@PathVariable("username") String username, @RequestBody CredentialsDto credentialsDto) {
		this.userService.followUser(username, credentialsDto);
	}
	
	@PostMapping("user/@{username}/unfollow")
	public void unfollowUser(@PathVariable("username") String username, @RequestBody CredentialsDto credentialsDto) {
		this.userService.unfollowUser(username, credentialsDto);
	}
	
	//@GetMapping("user/@{username}/feed")
	//@GetMapping("user/@{username}/tweets")
	//@GetMapping("user/@{username}/mentions")
	
	@GetMapping("user/@{username}/followers")
	public Set<UserResponseDto> getFollowers(@PathVariable("username") String username) {
		return this.userService.getFollowers(username);
	}
	
	@GetMapping("user/@{username}/following")
	public Set<UserResponseDto> getFollowings(@PathVariable("username") String username) {
		return this.userService.getFollowings(username);
	}
}