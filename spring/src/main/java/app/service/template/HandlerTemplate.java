package app.service.template;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.JsonNode;

import app.service.DataManager;
import app.service.JsonWebSocketHandler;

/**
 * Pass an arbitrary command code into @Component
 *
 * @author bo.wang1
 *
 */
@Component("template")
public class HandlerTemplate extends JsonWebSocketHandler {
	/**
	 * This is the approach to use DataManager
	 */
	@Autowired
	private @SuppressWarnings("unused") DataManager manager;

	@Override
	public void handleJsonMessage(WebSocketSession session, JsonNode node) throws IOException {
		session.sendMessage(
				new TextMessage(String.format("This is a handler template, your payload is %s", node.toString())));
	}
}