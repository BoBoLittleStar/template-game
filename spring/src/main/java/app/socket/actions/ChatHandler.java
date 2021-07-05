package app.socket.actions;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.JsonNode;

import app.game.Game;
import app.socket.DataManager;
import app.socket.JsonWebSocketHandler;
import app.util.Builder;

@Component("chat-message")
public class ChatHandler extends JsonWebSocketHandler {
	@Autowired
	private DataManager manager;

	@Override
	public void handleJsonMessage(WebSocketSession session, JsonNode node) throws IOException {
		String userId = manager.mapSessionUser.get(session.getId());
		String message = node.get("message").asText();
		Game game = manager.mapUserGame.get(userId);
		if (game != null) {
			String[] players = game.getPlayerIds();
			for (String player : players)
				if (game.isOnline(player))
					manager.mapUserSession.get(player)
							.sendMessage(new Builder().put(player, message).toMessage("chat-message"));
		}
	}
}