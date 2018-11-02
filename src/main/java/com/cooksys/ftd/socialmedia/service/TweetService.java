package com.cooksys.ftd.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.ftd.socialmedia.dto.CredentialsDto;
import com.cooksys.ftd.socialmedia.dto.TweetRequestDto;
import com.cooksys.ftd.socialmedia.dto.TweetResponseDto;
import com.cooksys.ftd.socialmedia.entity.Tweet;
import com.cooksys.ftd.socialmedia.entity.User;
import com.cooksys.ftd.socialmedia.mapper.TweetMapper;
import com.cooksys.ftd.socialmedia.repository.TweetRepository;
import com.cooksys.ftd.socialmedia.repository.UserRepository;

@Service
public class TweetService {
	
	private TweetRepository tweetRepository;
	private TweetMapper tweetMapper;
	private UserRepository userRepository;
	
	@Autowired
	public TweetService(TweetRepository tweetRepository, TweetMapper tweetMapper, UserRepository userRepository) {
		super();
		this.tweetRepository = tweetRepository;
		this.tweetMapper = tweetMapper;
		this.userRepository = userRepository;
	}
	
	public List<TweetResponseDto> getAllTweets() {
		return this.tweetMapper.entitiesToResponseDtos(this.tweetRepository.findAll());
	}
	
	public TweetResponseDto saveTweet(TweetRequestDto tweetRequestDto) {
		User user = this.userRepository.findUserByCredentials(tweetRequestDto.getCredentials());
		Tweet tweet = this.tweetRepository.save(new Tweet(user, tweetRequestDto.getContent()));
		return this.tweetMapper.entityToResponseDto(tweet);
	}// TODO: make it so it doesn't return ALL the user's information.
	
	public TweetResponseDto getTweet(Long id) {
		return this.tweetMapper.entityToResponseDto(this.tweetRepository.findTweetById(id));
	}
	
	public TweetResponseDto deleteTweet(Long id, CredentialsDto credentialsDto) {
		Tweet tweet = this.tweetRepository.findTweetById(id);
		if (tweet.getAuthor().getCredentials().equals(credentialsDto.getCredentials())) {
			this.tweetRepository.delete(tweet);
			return this.tweetMapper.entityToResponseDto(tweet);
		}
		return null;
	}// TODO: make it so it doesn't return ALL the user's information.
	
}
