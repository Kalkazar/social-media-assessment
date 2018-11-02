package com.cooksys.ftd.socialmedia.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.ftd.socialmedia.dto.TweetRequestDto;
import com.cooksys.ftd.socialmedia.dto.TweetResponseDto;
import com.cooksys.ftd.socialmedia.entity.Tweet;

@Mapper(componentModel = "spring")
public interface TweetMapper {
	
	TweetRequestDto entityToRequestDto(Tweet tweet);
	Tweet requestDtoToEntity(TweetRequestDto dto);
	
	TweetResponseDto entityToResponseDto(Tweet tweet);
	Tweet responseDtoToEntity(TweetResponseDto dto);
	
	List<TweetResponseDto> entitiesToResponseDtos(List<Tweet> tweets);
	
}