package com.cooksys.ftd.socialmedia.dto;

import com.cooksys.ftd.socialmedia.entity.Credentials;

public class TweetRequestDto {
	
	private String content;
	private Credentials credentials;
	
	public TweetRequestDto() {}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	
}
