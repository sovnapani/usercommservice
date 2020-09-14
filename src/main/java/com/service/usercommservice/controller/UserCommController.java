package com.service.usercommservice.controller;

import com.service.usercommservice.model.UserCommMessage;
import com.service.usercommservice.service.UserCommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class UserCommController {
	
	@Autowired
	UserCommService userCommService;
	
	
	@PostMapping(value = "/send")
	public String send(@RequestBody UserCommMessage userCommMessage) {
		return userCommService.send(userCommMessage);
	}
	

}
