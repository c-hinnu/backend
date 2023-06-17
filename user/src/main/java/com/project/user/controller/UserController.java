package com.project.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.user.model.User;
import com.project.user.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userservice;
	
	@PostMapping("/user")
	public  ResponseEntity<User> AddUser(@RequestBody User user)
	{
		return ResponseEntity.ok().body(userservice.addnew(user));
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getcourseById(@PathVariable int id) {
		
		var user= userservice.findUserById(id);
		
	if(user==null) 
	    {
		return  ResponseEntity.noContent().build();
		}
		return  ResponseEntity.ok().body(user);
	}
	@PutMapping("/users/{id}")
	public ResponseEntity<User> UpdateCourse(@RequestBody User user,@PathVariable int id)
	{
		return userservice.updateUser(user,id);
	}
}
