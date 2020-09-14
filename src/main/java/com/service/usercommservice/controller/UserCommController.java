package com.service.usercommservice.controller;

import com.service.usercommservice.model.Message;
import com.service.usercommservice.service.UserCommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@EnableAutoConfiguration
public class UserCommController {
	
	@Autowired
	UserCommService userCommService;
	
	
	@PostMapping(value = "/send")
	public String send(@RequestBody Map<String, List<Message>> userCommMessage) {
		return userCommService.send(userCommMessage);
	}
	

}
