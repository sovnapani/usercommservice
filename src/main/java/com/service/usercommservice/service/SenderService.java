package com.service.usercommservice.service;

import com.service.usercommservice.model.MessageType;
import com.service.usercommservice.sender.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.stream.Collectors;

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
