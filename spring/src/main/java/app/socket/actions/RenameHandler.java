package app.socket.actions;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.JsonNode;

import app.socket.DataManager;
import app.socket.JsonWebSocketHandler;

@Component("rename")
public class RenameHandler extends JsonWebSocketHandler {
	@Autowired
	private DataManager manager;

	@Override
	public void handleJsonMessage(WebSocketSession session, JsonNode node) throws IOException {
		manager.mapUserName.put(manager.mapSessionUser.get(session.getId()), node.get("name").asText());
	}
}