package app.socket;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import app.game.Game;

@Component
public class DataManager {
	public final Map<String, String> mapSessionUser = new ConcurrentHashMap<>();
	public final Map<String, WebSocketSession> mapUserSession = new ConcurrentHashMap<>();
	public final Map<String, String> mapUserName = new ConcurrentHashMap<>();
	public final Map<String, Game> mapUserGame = new HashMap<>();
}