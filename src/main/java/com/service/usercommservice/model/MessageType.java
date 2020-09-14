package com.service.usercommservice.model;

public enum MessageType {
	
	EMAIL("email"),SMS("sms"),GCMN("GCM_notification");
	
	private String type;

	MessageType(String type) {
		this.type=type;
	}

	public String getType() {
		return type;
	}
	
	public String toString()
	{
		return type;
	}

}
