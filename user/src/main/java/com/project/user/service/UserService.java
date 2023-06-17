package com.project.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.project.user.model.User;
import com.project.user.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepository userrepository;

	public User addnew(User user) {
		
		return userrepository.save(user);
	}

	public User findUserById(int id) {
		var result = userrepository.findById(id);
		User  user=result.get();
		return user;
		
		
	
	}

	public ResponseEntity<User> updateUser(User user, int id) {
		var u=userrepository.findById(id);
		if(u.isPresent())
		{
			return ResponseEntity.ok().body(userrepository.save(user));
			
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	
	
	}

	
}
