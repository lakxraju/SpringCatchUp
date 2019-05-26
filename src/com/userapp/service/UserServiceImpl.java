package com.userapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userapp.model.User;
import com.userapp.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public List<User> getAllUsers() {
		List<User> resultUsers = new ArrayList<>();
		userRepo.findAll().forEach((user) -> {
			resultUsers.add(user);
		});
		return resultUsers;
	}
	
	@Override
	public Optional<User> getUserById(long userId) {
		return userRepo.findById(userId);
	}

	@Override
	@Transactional
	public User update(User user) {
		return userRepo.save(user);
	}
}
