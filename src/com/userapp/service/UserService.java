package com.userapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.userapp.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public Optional<User> getUserById(long userId);
	
	public User update(User user);
}
