package app.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AppHandler extends TextWebSocketHandler {
	@Autowired
	private Map<String, JsonWebSocketHandler> commandHandlers;

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
		var node = new ObjectMapper().readTree(message.getPayload());
		var command = node.get("command").asText();
		var handler = commandHandlers.get(command);
		if (handler == null)
			System.out.println(String.format("Command %s is not defined", command));
		else
			handler.handleJsonMessage(session, node.get("payload"));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		var closeHandler = commandHandlers.get("session-close");
		if (closeHandler != null)
			closeHandler.afterConnectionClosed(session, status);
	}
}