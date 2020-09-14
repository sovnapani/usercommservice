package com.service.usercommservice.job;

import java.util.List;

import com.service.usercommservice.model.Message;
import com.service.usercommservice.model.MessageType;

public interface Publisher {

	public MessageType getMessageType();
	
	public void publish(List<Message> messages);
	
}
