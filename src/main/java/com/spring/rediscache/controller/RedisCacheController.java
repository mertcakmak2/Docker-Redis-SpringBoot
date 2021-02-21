package com.spring.rediscache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rediscache.entity.User;
import com.spring.rediscache.service.UserService;

@RestController
@RequestMapping("/api")
public class RedisCacheController {
	

	@Autowired
	private UserService service;

	
	@GetMapping("/getusers")
	public List<User> getUsers()  {
		return service.getUsers();
	}
	
	@PostMapping("/postuser")
    public User postUser(@RequestBody User user){
		User newUser = service.postUser(user);
		service.clearCache();
        return newUser;
    }
	
	@GetMapping("/deleteuser")
	public int deleteUser(@RequestParam int id) {
		service.clearCache();
		return service.deleteUser(id);
	}
	
}
