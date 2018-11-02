package com.cooksys.ftd.socialmedia.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.ftd.socialmedia.dto.CredentialsDto;
import com.cooksys.ftd.socialmedia.dto.UserResponseDto;
import com.cooksys.ftd.socialmedia.dto.UserRequestDto;
import com.cooksys.ftd.socialmedia.entity.User;
import com.cooksys.ftd.socialmedia.mapper.UserMapper;
import com.cooksys.ftd.socialmedia.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private UserMapper userMapper;
	
	@Autowired
	public UserService(UserRepository userRepository, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}
	
	public List<UserResponseDto> getAllUsers() {
		return this.userMapper.entitiesToResponseDtos(this.userRepository.findAll());
	}
	
	// THIS SHOULDN'T OVERWRITE ANYTHING
	public UserResponseDto saveUser(UserRequestDto userRequestDto) {
		User user = this.userRepository.save(this.userMapper.requestDtoToEntity(userRequestDto));
		return this.userMapper.entityToResponseDto(user);
	}// will work if 409 conflict
	
	// This could easily be one line, but I'm leaving it like this for the sake of code uniformity.
	public UserResponseDto getUser(String username) {
		User user = this.userRepository.findUserByCredentialsUsername(username);
		return this.userMapper.entityToResponseDto(user);
	}
	
	public UserResponseDto editUser(String username, UserRequestDto userRequestDto) {
		User user = this.userRepository.findUserByCredentialsUsername(username);
		if (user.getCredentials().equals(userRequestDto.getCredentials())) {
			user.setProfile(userRequestDto.getProfile());
		}
		return this.userMapper.entityToResponseDto(this.userRepository.save(user)); // TODO: throw exception
	}
	
	public UserResponseDto deleteUser(String username, CredentialsDto credentialsDto) {
		User user = this.userRepository.findUserByCredentialsUsername(username);
		if (user.getCredentials().equals(credentialsDto.getCredentials())) {
			this.userRepository.delete(user);
			return this.userMapper.entityToResponseDto(user);
		}
		return null;// TODO: throw exception
	}
	
	public void followUser(String username, CredentialsDto credentialsDto) {
		User followingUser = this.userRepository.findUserByCredentials(credentialsDto.getCredentials());
		User followedUser = this.userRepository.findUserByCredentialsUsername(username);
		Set<User> followings = followingUser.getFollowings();
		Set<User> followers = followedUser.getFollowers();
		if (followers.add(followingUser) && followings.add(followedUser)) {
			followingUser.setFollowings(followings);
			followedUser.setFollowers(followers);
			this.userRepository.save(followingUser);
			this.userRepository.save(followedUser);
			System.out.println("IT WORKED!");
			return;
		}
		System.out.println("IT DIDN'T WORK");// TODO: throw exception
	}
	
	public void unfollowUser(String username, CredentialsDto credentialsDto) {
		User followingUser = this.userRepository.findUserByCredentials(credentialsDto.getCredentials());
		User followedUser = this.userRepository.findUserByCredentialsUsername(username);
		Set<User> followings = followingUser.getFollowings();
		Set<User> followers = followedUser.getFollowers();
		if (followers.remove(followingUser) && followings.remove(followedUser)) {
			followingUser.setFollowings(followings);
			followedUser.setFollowers(followers);
			this.userRepository.save(followingUser);
			this.userRepository.save(followedUser);
			System.out.println("IT WORKED!");
			return;
		}
		System.out.println("IT DIDN'T WORK");// TODO: throw exception
	}
	
	public Set<UserResponseDto> getFollowers(String username) {
		User user = this.userRepository.findUserByCredentialsUsername(username);
		return this.userMapper.entitiesToResponseDtos(user.getFollowers());
	}// TODO: throw exception
	
	public Set<UserResponseDto> getFollowings(String username) {
		User user = this.userRepository.findUserByCredentialsUsername(username);
		return this.userMapper.entitiesToResponseDtos(user.getFollowings());
	}// TODO: throw exception
}
