package com.cooksys.ftd.socialmedia.dto;

import com.cooksys.ftd.socialmedia.entity.Credentials;
import com.cooksys.ftd.socialmedia.entity.Profile;

public class UserRequestDto {
	
	private Credentials credentials;
	private Profile profile;
	
	public UserRequestDto() {}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credential) {
		this.credentials = credential;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
}
