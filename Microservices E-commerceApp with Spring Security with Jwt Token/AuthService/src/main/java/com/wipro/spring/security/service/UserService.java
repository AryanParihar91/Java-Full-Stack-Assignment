package com.wipro.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.spring.security.entity.UserInfo;
import com.wipro.spring.security.repository.IUserRepository;

@Service
public class UserService {

	@Autowired
	private IUserRepository repo;

	@Autowired
	private PasswordEncoder encoder;

	public String register(UserInfo user) {

		user.setPassword(encoder.encode(user.getPassword()));

		repo.save(user);

		return "User Registered";
	}
}