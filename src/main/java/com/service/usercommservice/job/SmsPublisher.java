package com.service.usercommservice.job;

import com.service.usercommservice.model.Message;
import com.service.usercommservice.model.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
public class SmsPublisher implements Publisher{

	
	@Autowired
	JmsTemplate jmsTemplate;

	public void publish(List<Message> messages) {
		for(Message message : messages) {
			UUID uuid=UUID.randomUUID();
//			message.setUuid(uuid.toString());
			jmsTemplate.convertAndSend("sms",message);
		}
		
	}

	@Override
	public MessageType getMessageType() {
		// TODO Auto-generated method stub
		return MessageType.SMS;
	}
	
	


}
