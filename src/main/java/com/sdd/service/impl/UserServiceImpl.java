package com.sdd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdd.exception.ResourceNotFoundException;
import com.sdd.model.UserEntity;
import com.sdd.repo.UserRepo;
import com.sdd.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserEntity> users = userRepo.findAll();
		return users;
	}

	@Override
	public UserEntity getUserById(Integer userId) {
		// TODO Auto-generated method stub
		UserEntity user = userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		return user;
	}

	@Override
	public UserEntity saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public UserEntity updateUser(UserEntity user) {
		UserEntity existingUser = 
				userRepo.findById(user.getUserId())
				.orElseThrow(()-> new ResourceNotFoundException("User", "userId", user.getUserId()));
		return userRepo.save(user);
	}

	@Override
	public String deleteUser(Integer userId) {
		UserEntity existingUser = 
				userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
		// TODO Auto-generated method stub
		userRepo.deleteById(userId);
		return "User " + existingUser.getFirstName() + " " + existingUser.getLastName() + " is Successfully deleted."; 
	}

}
