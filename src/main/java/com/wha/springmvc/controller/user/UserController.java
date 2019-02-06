package com.wha.springmvc.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.service.user.IUserService;

@RestController
public class UserController {
	@Autowired
	private IUserService service;
}
