package com.LibraryManagementSystem.Controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryManagementSystem.Model.UserEntity;
import com.LibraryManagementSystem.Service.UserService;

@RestController
public class UserController {
	@Autowired  
	UserService userService;   
	
	@GetMapping("/getAllUsers")
	public List<UserEntity> getUsers(){
		return userService.getAllUsers();
	}
	@GetMapping("/getUserById/{id}")
	public UserEntity findUserById(@PathVariable Long id) {	
		return userService.getUserById(id);
	}

	
	@PostMapping("/addUser")
	public UserEntity saveUser(@RequestBody UserEntity userEntity) {
		return userService.addUser(userEntity);
	}
	
	@PutMapping("/editUser/{id}")
	public UserEntity updateUser(@RequestBody UserEntity userEntity,@PathVariable Long id ){
		userEntity.setUserId(id);
		return userService.editUser(userEntity);
	}
	
}
