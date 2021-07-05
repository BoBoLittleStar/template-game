package app.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.TextMessage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A convenient class for creating JSON object
 *
 * @author bo.wang1
 *
 */
public class Builder {
	private Map<String, Object> map = new HashMap<>();

	public Builder put(String k, Object v) {
		map.put(k, v);
		return this;
	}

	public TextMessage toMessage(String command) throws JsonProcessingException {
		Map<String, Object> map = new HashMap<>();
		map.put("command", command);
		map.put("payload", this.map);
		return new TextMessage(new ObjectMapper().writeValueAsString(map));
	}
}