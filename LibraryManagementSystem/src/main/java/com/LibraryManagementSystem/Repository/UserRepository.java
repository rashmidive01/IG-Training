package com.LibraryManagementSystem.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LibraryManagementSystem.Model.UserEntity;
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	List<UserEntity> findByUserName(String name);
	UserEntity findByUserId(Long id);

}
