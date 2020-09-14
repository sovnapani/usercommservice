package com.service.usercommservice.model;


public class Message {	
	
	private String uuid;
	private String from;
	private String to;
	private String subject;
	private String body;
	private MessageType messageType;
	
	public Message() {
		super();
	}


	public Message(String from, String to, String subject, String body, MessageType type) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.body = body;
		this.messageType = type;
	}
	
	
	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public MessageType getMessageType() {
		return messageType;
	}


	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}


	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public int hashCode() {
		int result = 0;
		result = result + ((from == null) ? 0 : from.hashCode());
		result = result + ((to == null) ? 0 : to.hashCode());
		result = result + ((messageType == null) ? 0 : messageType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		if (messageType != other.messageType)
			return false;
		return true;
	}
	
	
	

}
