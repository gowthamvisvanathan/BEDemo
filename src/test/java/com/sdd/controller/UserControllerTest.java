package com.sdd.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sdd.model.AppResponse;
import com.sdd.model.UserEntity;
import com.sdd.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
	
	@InjectMocks
	UserController userConroller;
	
	@Mock
	UserService userService;

	@Test
	void testGetAllUsers() {
		
		UserEntity user1 = new UserEntity(1,"Gowtham","Visvanathan",35,"Male","1234567890","test123@gmail.com");
		UserEntity user2 = new UserEntity(2,"New","User",20,"Female","334984598","test@gmail.com");
		UserEntity user3 = new UserEntity(3,"Hello","Kim",15,"Male","9979300","123@gmail.com");
        List<UserEntity> users = new ArrayList<>(List.of(user1, user2, user3));
 
        when(userService.getAllUsers()).thenReturn(users);
 
        // when
        ResponseEntity<AppResponse> responseEntity = userConroller.getAllUsers();
 
        // then
        List<UserEntity> responseUsers = (List<UserEntity>) responseEntity.getBody().getData();
        System.out.println(responseUsers);
        
        assertThat(responseUsers.size()).isEqualTo(3);
        assertThat(responseUsers.get(0).getFirstName())
        			.isEqualTo(user1.getFirstName());
    }
	

	@Test
	void testGetUser() {
//		fail("Not yet implemented");
	}

	@Test
	void testSaveUser() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        UserEntity user = new UserEntity(1,"Gowtham","Visvanathan",35,"Male","1234567890","test123@gmail.com");
        
        when(userService.saveUser(any(UserEntity.class))).thenReturn(user);
        
        ResponseEntity<AppResponse> responseEntity = userConroller.saveUser(user);
        
        System.out.println(responseEntity.getBody().getData());
        System.out.println(responseEntity.getBody().getMessage());
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().getMessage().toString()).isEqualTo("User 'Gowtham  Visvanathan' successfully saved.");
        assertEquals(user, responseEntity.getBody().getData());
	}

	@Test
	void testUpdateUser() {
//		fail("Not yet implemented");
	}

	@Test
	void testDeleteUser() {
//		fail("Not yet implemented");
	}

}
