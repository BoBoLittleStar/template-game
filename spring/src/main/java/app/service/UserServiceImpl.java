package app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.data.user.User;
import app.data.user.UserRepository;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repo;

	@Override
	public User getUser(UUID uuid) {
		return repo.getById(uuid);
	}

	@Override
	public boolean createUser(String email, String password) {
		List<User> users = repo.findAll();
		for (User user : users)
			if (user.getEmail().equals(email))
				return false;
		repo.save(new User(email, password));
		return true;
	}
}