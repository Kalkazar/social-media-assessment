package com.cooksys.ftd.socialmedia.dto;

import com.cooksys.ftd.socialmedia.entity.Profile;
import com.cooksys.ftd.socialmedia.entity.User;

public class TweetResponseDto {
	
	private Long id;
	private User author; // does this need to be an UserResponseDto?
//	private String username;
//	private Profile profile;
	
	public TweetResponseDto() {}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public Profile getProfile() {
//		return profile;
//	}
//
//	public void setProfile(Profile profile) {
//		this.profile = profile;
//	}
	
}
