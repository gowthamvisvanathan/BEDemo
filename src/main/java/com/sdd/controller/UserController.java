package com.sdd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sdd.model.AppResponse;
import com.sdd.model.UserEntity;
import com.sdd.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/all")
	public ResponseEntity<AppResponse> getAllUsers() {
		List<UserEntity> allUsers = userService.getAllUsers();
		AppResponse appResp = new AppResponse();
		appResp.setData(allUsers);
		appResp.setCode(HttpStatus.OK.value());
		appResp.setMessage("List of all Users.");
		return new ResponseEntity<AppResponse>(appResp, HttpStatus.OK);
		
	}
	
	@GetMapping()
	public ResponseEntity<AppResponse> getUser(@RequestParam Integer userId) {
		UserEntity user = userService.getUserById(userId);
		AppResponse appResp = new AppResponse();
		appResp.setData(user);
		appResp.setCode(HttpStatus.OK.value());
		appResp.setMessage(String.format("User '%s %s' found.", user.getFirstName(), user.getLastName()));
		return new ResponseEntity<AppResponse>(appResp, HttpStatus.OK);
		
	}
	
	@PostMapping()
	public ResponseEntity<AppResponse> saveUser(@RequestBody UserEntity user) {
		AppResponse appResp = new AppResponse();
		appResp.setData(userService.saveUser(user));
		appResp.setCode(HttpStatus.OK.value());
		appResp.setMessage(String.format("User '%s  %s' successfully saved.", 
				user.getFirstName(), user.getLastName()));
		return new ResponseEntity<AppResponse>(appResp, HttpStatus.OK);
		
	}
	
	@PutMapping()
	public ResponseEntity<AppResponse> updateUser(@RequestBody UserEntity user) {
		AppResponse appResp = new AppResponse();
		appResp.setData(userService.updateUser(user));
		appResp.setCode(HttpStatus.OK.value());
		appResp.setMessage(String.format("User '%s  %s' successfully updated.", 
				user.getFirstName(), user.getLastName()));
		return new ResponseEntity<AppResponse>(appResp, HttpStatus.OK);
		
	}
	
	@DeleteMapping()
	public ResponseEntity<AppResponse> deleteUser(@RequestParam Integer userId) {
		AppResponse appResp = new AppResponse();
		String delMsg = userService.deleteUser(userId);
		appResp.setData(delMsg);
		appResp.setCode(HttpStatus.OK.value());
		appResp.setMessage(delMsg);
		return new ResponseEntity<AppResponse>(appResp, HttpStatus.OK);
		
	}
}
