package com.selzlein.djeison.springwebsocketsrabbitmqdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config
			.setApplicationDestinationPrefixes("/app")
			.enableStompBrokerRelay("/topic")
			.setRelayHost("localhost")
			.setRelayPort(61613)
			.setClientLogin("guest")
			.setClientPasscode("guest");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/websocket-app").withSockJS();
	}

}
