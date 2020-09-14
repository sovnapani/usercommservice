package com.service.usercommservice.service;

import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.service.usercommservice.model.MessageType;
import com.service.usercommservice.sender.Sender;

@Component
public class SenderService {
	

	@Autowired
	private ApplicationContext applicationContext;
	
	Map<MessageType, Sender> senderMap ;
	
	@PostConstruct
	public void init()
	{
		senderMap = applicationContext.getBeansOfType(Sender.class).values().stream().collect(Collectors.toMap(s->s.getMessageType(), s->s));
	}
	
	public void send() {
		
	}

}
