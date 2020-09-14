package com.service.usercommservice.controller;

import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.service.usercommservice.model.Message;
import com.service.usercommservice.model.MessageType;
import com.service.usercommservice.sender.SMSSender;
import com.service.usercommservice.sender.Sender;
import com.service.usercommservice.service.SenderService;

@Component
public class MessageJMSController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private ApplicationContext applicationContext;
	
	Map<MessageType, Sender> senderMap ;
	
	@PostConstruct
	public void init()
	{
		senderMap = applicationContext.getBeansOfType(Sender.class).values().stream().collect(Collectors.toMap(s->s.getMessageType(), s->s));
	}
	

  @JmsListener(destination = "sms")
  public void receiveSmsMessage(Message message) {
	  
    logger.info("Received <{}>" , message);
    senderMap.get(MessageType.SMS).sendMessage(message);
    
  }
  @JmsListener(destination = "email")
  public void receiveEmailMessage(Message message) {
    logger.info("Received <{}>" , message);
    senderMap.get(MessageType.EMAIL).sendMessage(message);
  }
  @JmsListener(destination = "gcm")
  public void receiveGCMNMessage(Message message) {
    logger.info("Received <{}>" , message);
    senderMap.get(MessageType.GCMN).sendMessage(message);
  }
  
  
}