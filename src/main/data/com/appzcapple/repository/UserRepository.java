package com.appzcapple.repository;

import org.springframework.stereotype.Repository;

import com.appzcapple.models.User;

@Repository
public interface UserRepository {
	
	User getUserById(int id);
	
}
