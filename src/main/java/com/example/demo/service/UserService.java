package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {

	 public void saveUser(User user);
	    public List<Object> isUserPresent(User user);
	    
	    public List<User> getAll();
}
