package com.selzlein.djeison.springwebsocketsrabbitmqdemo.web;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessagingController {

	@MessageMapping("/message")
	@SendTo("/topic/mural")
	public String send(String message) throws Exception {
		return message;
	}

}
