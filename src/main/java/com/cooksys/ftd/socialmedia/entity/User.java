package com.cooksys.ftd.socialmedia.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {// you can use an auto-generated id... just don't send it in the DTO
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;// consider renaming to "userId"
	
	@Column(unique = true)
	private String username;
	
	@JoinColumn(name="profile_fk")
	@ManyToOne
	private Profile profile;
	
	@Column
	private Timestamp timestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
}
