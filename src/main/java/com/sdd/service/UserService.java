package com.sdd.service;

import java.util.List;

import com.sdd.model.UserEntity;

public interface UserService {
	List<UserEntity> getAllUsers();
	UserEntity getUserById(Integer userId);
	UserEntity saveUser(UserEntity user);
	UserEntity updateUser(UserEntity user);
	String deleteUser(Integer userId);
}
