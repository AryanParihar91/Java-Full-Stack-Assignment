package com.wipro.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wipro.spring.security.repository.IUserRepository;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) {

		return repository.findByUsername(username).map(UserInfoUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}
}
