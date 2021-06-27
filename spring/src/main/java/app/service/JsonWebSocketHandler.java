package app.service;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * A general WebSocketHandler class for processing JSON messages
 *
 * @author bo.wang1
 *
 */
public abstract class JsonWebSocketHandler extends TextWebSocketHandler {
	public abstract void handleJsonMessage(WebSocketSession session, JsonNode node);
}