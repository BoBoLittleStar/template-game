package app.socket.actions;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.JsonNode;

import app.socket.DataManager;
import app.socket.JsonWebSocketHandler;
import app.util.Builder;

@Component("session-open")
public class OpenHandler extends JsonWebSocketHandler {
	@Autowired
	private DataManager manager;

	@Override
	public void handleJsonMessage(WebSocketSession session, JsonNode node) throws IOException {
		String userId = node.get("id").asText();
		String userName = node.get("name").asText();
		manager.mapSessionUser.put(session.getId(), userId);
		manager.mapUserSession.put(userId, session);
		manager.mapUserName.put(userId, userName);
		int size = manager.mapUserSession.size();
		manager.mapUserSession.values().forEach((elem) -> {
			try {
				elem.sendMessage(new Builder().put("totalPlayers", size).toMessage("total-players"));
			} catch (IOException E) {
				E.printStackTrace();
			}
		});
	}
}