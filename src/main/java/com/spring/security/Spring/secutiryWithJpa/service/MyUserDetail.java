package com.spring.security.Spring.secutiryWithJpa.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.security.Spring.secutiryWithJpa.model.User;

public class MyUserDetail implements UserDetails {
	
	private String userName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> autorities;

	public MyUserDetail(User user) {
		this.userName=user.getUserName();
		this.password=user.getPassword();
		this.active=user.getActive();
		this.autorities=Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority:: new)
				.collect(Collectors.toList());
		// TODO Auto-generated constructor stub
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return autorities;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
