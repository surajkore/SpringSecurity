package com.spring.security.Spring.secutiryWithJpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.Spring.secutiryWithJpa.model.User;
import com.spring.security.Spring.secutiryWithJpa.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository repository;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	Optional<User>	user=repository.findByUserName(userName);
	user.orElseThrow(()-> new UsernameNotFoundException("not found"+userName));
	
		return user.map(MyUserDetail::new ).get();
		
	}

}
