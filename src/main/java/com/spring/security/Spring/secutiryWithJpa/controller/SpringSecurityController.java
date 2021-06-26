package com.spring.security.Spring.secutiryWithJpa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.Spring.secutiryWithJpa.model.User;
import com.spring.security.Spring.secutiryWithJpa.repository.UserRepository;

@RestController
@RequestMapping("/security")
public class SpringSecurityController {
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	UserRepository repo;
	
	@GetMapping("/")
	public String HomesUser() {
		User u=new User();
		u.setActive(true);
		u.setPassword(encoder.encode("pass"));
		
		u.setRoles("ROLE_ADMIN");
		u.setUserName("suraj");
		repo.save(u);
		return "home user login.....";
	}
	@GetMapping("/user")
	public String allUser() {
		
		
		
		return " user are access by using basic athenticatio and user save successfully..... ";
	}
	@GetMapping("/admin")
	public String admin() {
		
		return "Admin user are access by using basic athentication ";
	}

}
