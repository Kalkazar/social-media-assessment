package com.cooksys.ftd.socialmedia.mapper;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;

import com.cooksys.ftd.socialmedia.dto.UserRequestDto;
import com.cooksys.ftd.socialmedia.dto.UserResponseDto;
import com.cooksys.ftd.socialmedia.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserRequestDto entityToRequestDto(User entity);
	User requestDtoToEntity(UserRequestDto requestDto);
	
	UserResponseDto entityToResponseDto(User entity);
	User responseDtoToEntity(UserResponseDto responseDto);
	
	List<UserResponseDto> entitiesToResponseDtos(List<User> users);
	Set<UserResponseDto> entitiesToResponseDtos(Set<User> users);
}