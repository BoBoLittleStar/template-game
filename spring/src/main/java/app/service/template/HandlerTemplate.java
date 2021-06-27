package app.service.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.JsonNode;

import app.service.DataManager;
import app.service.JsonWebSocketHandler;

public class HandlerTemplate extends JsonWebSocketHandler {
	@Autowired
	private @SuppressWarnings("unused") DataManager manager;

	@Override
	public void handleJsonMessage(WebSocketSession session, JsonNode node) {
		System.out.println("This is a handler template");
	}
}