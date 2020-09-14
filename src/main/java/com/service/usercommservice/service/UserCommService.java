package com.service.usercommservice.service;

import com.service.usercommservice.job.Publisher;
import com.service.usercommservice.model.Message;
import com.service.usercommservice.model.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UserCommService {
	
	
	@Autowired
	private ApplicationContext applicationContext;
	
	Map<MessageType, Publisher> publisherMap ;
	
	@PostConstruct
	public void init()
	{
		publisherMap = applicationContext.getBeansOfType(Publisher.class).values().stream().collect(Collectors.toMap(p->p.getMessageType(), p->p));
	}
	
	public String send(Map<String,List<Message>> userCommMessage) {

		for(Map.Entry<String,List<Message>> entry : userCommMessage.entrySet()){
			publisherMap.get(Enum.valueOf(MessageType.class,entry.getKey().toUpperCase())).publish(entry.getValue());
		}

		return "OK";
		
	}

}
