package app.data.user;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {
	private @Id @GeneratedValue @Getter UUID uuid;
	private @Getter String password;
	private @Getter String email;
	private @Setter @Getter String token;
	private @Setter @Getter long expireTime;

	public User(String password, String email) {
		this.password = password;
		this.email = email;
	}
}