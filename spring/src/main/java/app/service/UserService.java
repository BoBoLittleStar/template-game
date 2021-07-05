package app.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import app.data.user.User;

@Service
public interface UserService {
	User getUser(UUID uuid);

	boolean createUser(String email, String password);
}