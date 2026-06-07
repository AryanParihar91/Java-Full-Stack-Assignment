package com.wipro.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.spring.security.dto.LoginRequest;
import com.wipro.spring.security.entity.UserInfo;
import com.wipro.spring.security.service.JwtService;
import com.wipro.spring.security.service.UserService;

@RestController
@RequestMapping("/users")
public class AuthController {

	@Autowired
	private UserService service;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping("/registration/new")
	public String register(@RequestBody UserInfo user) {
		return service.register(user);
	}

	@PostMapping("/login/authenticate")
	public String login(@RequestBody LoginRequest req) {

		manager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));

		UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());

		return jwtService.generateToken(userDetails);
	}
}
