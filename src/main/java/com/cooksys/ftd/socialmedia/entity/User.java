package com.cooksys.ftd.socialmedia.entity;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private Credentials credentials;
	
	@Embedded
	private Profile profile;
	
	@Column
	private Timestamp joined;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<User> followings;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<User> followers;
	
	public User() {
		this.joined = new Timestamp(System.currentTimeMillis());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	
	public String getUsername() {
		return this.credentials.getUsername();
	}
	
	public void setUsername(String username) {
		this.credentials.setUsername(username);
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Timestamp getJoined() {
		return joined;
	}

	public Set<User> getFollowings() {
		return followings;
	}

	public void setFollowings(Set<User> following) {
		this.followings = following;
	}
	
	public Set<User> getFollowers() {
		return followers;
	}
	
	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((credentials == null) ? 0 : credentials.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this != obj || obj == null || getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		
		String thisName = this.credentials.getUsername();
		String otherName = other.credentials.getUsername();
		
		if (thisName == null && otherName != null) {
			return false;
		} 
		return !thisName.equals(otherName);
	}
	
}