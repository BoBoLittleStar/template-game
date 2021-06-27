package app.service.template;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.JsonNode;

import app.service.JsonWebSocketHandler;

@Component("session-close")
public class CloseHandler extends JsonWebSocketHandler {

	/**
	 * CloseHandler is not receiving any data
	 */
	@Override
	public void handleJsonMessage(WebSocketSession session, JsonNode node) {
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		System.out.println(String.format("Session %s is closed", session.getId()));
	}
}