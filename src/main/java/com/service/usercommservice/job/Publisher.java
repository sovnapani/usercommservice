package com.service.usercommservice.job;

import com.service.usercommservice.model.Message;
import com.service.usercommservice.model.MessageType;

import java.util.List;

public interface Publisher {

	public MessageType getMessageType();
	
	public void publish(List<Message> messages);
	
}
