package com.service.usercommservice.service;

import com.service.usercommservice.job.Publisher;
import com.service.usercommservice.model.Message;
import com.service.usercommservice.model.MessageType;
import com.service.usercommservice.model.UserCommMessage;
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
	
	public String send(UserCommMessage userCommMessage) {
		List<Message> emails = userCommMessage.getEmail();
		if(emails!=null && emails.size()>0)
		{
			publisherMap.get(MessageType.EMAIL).publish(emails);
		}
		List<Message> sms = userCommMessage.getSms();
		if(sms!=null && sms.size()>0)
		{
			publisherMap.get(MessageType.SMS).publish(sms);
		}
		List<Message> gcm = userCommMessage.getGcm();
		if(gcm!=null && gcm.size()>0)
		{
			publisherMap.get(MessageType.GCMN).publish(gcm);
		}
		
		return "OK";
		
	}

}
