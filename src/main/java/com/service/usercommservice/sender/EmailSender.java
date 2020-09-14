package com.service.usercommservice.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.service.usercommservice.model.Message;
import com.service.usercommservice.model.MessageType;
@Component
public class EmailSender implements Sender{

	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void sendMessage(Message message) {
		
		//dummy for processing to send email to user
		logger.info("email is sent");
	}
	@Override
	public MessageType getMessageType() {
		// TODO Auto-generated method stub
		return MessageType.EMAIL;
	}
	
	

}