package app.socket.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.JsonNode;

import app.socket.DataManager;
import app.socket.JsonWebSocketHandler;

@Component("session-close")
public class CloseHandler extends JsonWebSocketHandler {
	@Autowired
	private DataManager manager;

	/**
	 * CloseHandler is not receiving any data
	 */
	@Override
	public void handleJsonMessage(WebSocketSession session, JsonNode node) {
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		String userId = manager.mapSessionUser.remove(session.getId());
		manager.mapUserSession.remove(userId);
	}
}