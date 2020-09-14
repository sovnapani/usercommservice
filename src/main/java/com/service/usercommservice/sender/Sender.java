package com.service.usercommservice.sender;

import com.service.usercommservice.model.Message;
import com.service.usercommservice.model.MessageType;

public interface Sender {
	
	public MessageType getMessageType();
	
	public void sendMessage(Message message);
	

}
