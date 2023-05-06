package com.mohamed.resturant.controller;

import com.mohamed.resturant.service.imp.LoginService;
import com.mohamed.resturant.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class LoginController {

	@Autowired
	private UserServiceImp userServiceImp;
	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
		return loginService.login(email, password);
	}
}
