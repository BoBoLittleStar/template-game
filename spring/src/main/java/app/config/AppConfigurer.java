package app.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import app.service.AppHandler;
import app.service.JsonWebSocketHandler;

@Configuration
@EnableWebSocket
public class AppConfigurer implements WebSocketConfigurer {
	private @Autowired AppHandler handler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(handler, "socket").setAllowedOrigins("*");
	}

	@Bean
	public Map<String, JsonWebSocketHandler> createHandler() {
		return new HashMap<>();
	}
}