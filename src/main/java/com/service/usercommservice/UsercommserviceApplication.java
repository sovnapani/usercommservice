package com.service.usercommservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class UsercommserviceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(UsercommserviceApplication.class, args);
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
	}

}
