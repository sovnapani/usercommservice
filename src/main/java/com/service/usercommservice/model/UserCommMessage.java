package com.service.usercommservice.model;

import java.io.Serializable;
import java.util.List;

public class UserCommMessage implements Serializable{
	
	List<Message> sms;
	List<Message> email;
	List<Message> gcm;
	public UserCommMessage(List<Message> sms, List<Message> email, List<Message> gcm) {
		super();
		this.sms = sms;
		this.email = email;
		this.gcm = gcm;
	}
	public List<Message> getSms() {
		return sms;
	}
	public void setSms(List<Message> sms) {
		this.sms = sms;
	}
	public List<Message> getEmail() {
		return email;
	}
	public void setEmail(List<Message> email) {
		this.email = email;
	}
	public List<Message> getGcm() {
		return gcm;
	}
	public void setGcm(List<Message> gcm) {
		this.gcm = gcm;
	}

	
	

}
