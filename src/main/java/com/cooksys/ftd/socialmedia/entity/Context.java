package com.cooksys.ftd.socialmedia.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//@Entity
public class Context {// NOT DONE. BARELY EVEN STARTED
	
	private Tweet target;
	
//	@JoinColumn(name = "author_fk")
//    @OneToOne
//	@OneToMany(mappedBy = "location")
	private List<Tweet> before; // DIFFERENT DATA TYPE
	
//	@JoinColumn(name = "author_fk")
//    @OneToOne
//	@OneToMany(mappedBy = "location")
	private List<Tweet> after; // DIFFERENT DATA TYPE
	
	private Long inReplyTo;
	
	private Long repostOf;
}
