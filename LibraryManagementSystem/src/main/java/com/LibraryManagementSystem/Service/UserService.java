package com.LibraryManagementSystem.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.LibraryManagementSystem.Model.BookEntity;
import com.LibraryManagementSystem.Model.UserEntity;
import com.LibraryManagementSystem.Repository.BookRepository;
import com.LibraryManagementSystem.Repository.UserRepository;
import com.LibraryManagementSystem.Model.UserEntity;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<UserEntity> getAllUsers()   
	{  
		return userRepository.findAll(); 
	}  
	public UserEntity addUser(UserEntity userEntity)   
	{  
		return userRepository.save(userEntity);  
	}
	public UserEntity editUser(UserEntity userEntity) {
		UserEntity userEntity2 = userRepository.findById(userEntity.getUserId()).orElse(null);
		userEntity2.setUserName(userEntity.getUserName());
		userEntity2.setUserAddress(userEntity.getUserAddress());
		userEntity2.setUserMailId(userEntity.getUserMailId());
		userEntity2.setUserType(userEntity.getUserType());
		userEntity2.setUserAge(userEntity.getUserAge());
		userEntity2.setGender(userEntity.getGender());
		return userRepository.save(userEntity2);
	}  
	public UserEntity getUserById(Long id) {
		return userRepository.findByUserId(id);
	}

}
