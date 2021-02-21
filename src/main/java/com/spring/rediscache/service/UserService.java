package com.spring.rediscache.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.spring.rediscache.entity.User;
import com.spring.rediscache.repositories.UserRepository;

@Service
@EnableCaching
public class UserService {
	
	@Autowired
	private UserRepository repos;

	@Cacheable(cacheNames = "userCache")
	public List<User> getUsers()  {
		System.out.println("Database'e gidildi.");
		return repos.findAll();
	}
	
    public User postUser (User user){
    	return repos.save(user);
    }

	public int deleteUser (int id) {
		repos.deleteById(id);
		return id;
	}
	
	@CacheEvict(cacheNames = "userCache")
	public void clearCache() {
		System.out.println("cache temizlendi.");
	}
}
