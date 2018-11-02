package com.cooksys.ftd.socialmedia.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Tweet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User author;
	
	@Column
	private Timestamp posted;
	
	@Column
	private String content;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Tweet inReplyTo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Tweet repostOf;
	
	public Tweet() {
		super();
		this.posted = new Timestamp(System.currentTimeMillis());
	}
	
	public Tweet(User author, String content) {
		super();
		this.author = author;
		this.content = content;
		this.posted = new Timestamp(System.currentTimeMillis());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAuthor() {
		return this.author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Timestamp getPosted() {
		return posted;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Credentials getCredentials() {
		return this.author.getCredentials();
	}

	public void setCredentials(Credentials credentials) {
		this.author.setCredentials(credentials);
	}

	public Tweet getInReplyTo() {
		return inReplyTo;
	}

	public void setInReplyTo(Tweet inReplyTo) {
		this.inReplyTo = inReplyTo;
	}

	public Tweet getRepostOf() {
		return repostOf;
	}

	public void setRepostOf(Tweet repostOf) {
		this.repostOf = repostOf;
	}
	
}// Maybe represent the "likes" as a list of users?
