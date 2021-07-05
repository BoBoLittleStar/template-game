package app.api;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.data.user.User;
import app.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping("/user/login")
	public boolean login(@RequestParam UUID id, @RequestParam String token) {
		User user = service.getUser(id);
		long now = System.currentTimeMillis();
		if (!user.getToken().equals(token) || user.getExpireTime() < now)
			return false;
		long sevenDays = 7 * 24 * 60 * 60 * 1000;
		user.setExpireTime(now + sevenDays);
		return true;
	}

	@PostMapping("/user/register")
	public boolean register(@RequestBody Map<String, ?> user) {
		System.out.println(user);
		return true;
	}
}