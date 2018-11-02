package com.cooksys.ftd.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.ftd.socialmedia.dto.CredentialsDto;
import com.cooksys.ftd.socialmedia.dto.TweetRequestDto;
import com.cooksys.ftd.socialmedia.dto.TweetResponseDto;
import com.cooksys.ftd.socialmedia.service.TweetService;

@RestController
public class TweetController {
	
	private TweetService tweetService;
	
	@Autowired
	public TweetController(TweetService tweetService) {
		super();
		this.tweetService = tweetService;
	}
	
	@GetMapping("tweets")
	public List<TweetResponseDto> getAllTweets() {
		return this.tweetService.getAllTweets();
	}
	
	@PostMapping("tweets")
	public TweetResponseDto saveTweet(@RequestBody TweetRequestDto tweetRequest) {
		return this.tweetService.saveTweet(tweetRequest);
	}
	
	@GetMapping("tweets/{id}")
	public TweetResponseDto getTweet(@PathVariable("id") Long id) {
		return this.tweetService.getTweet(id);
	}
	
	@DeleteMapping("tweets/{id}")
	public TweetResponseDto deleteTweet(Long id, CredentialsDto credentialsDto) {
		return this.tweetService.deleteTweet(id, credentialsDto);
	}
}
