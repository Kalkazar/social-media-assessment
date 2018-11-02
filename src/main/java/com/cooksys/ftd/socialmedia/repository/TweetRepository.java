package com.cooksys.ftd.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cooksys.ftd.socialmedia.entity.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
	
	Tweet findTweetById(Long id);
	
}