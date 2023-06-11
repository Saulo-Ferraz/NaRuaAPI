package com.example.NaRua.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String email;

	@OneToMany(mappedBy = "user")
	private List<PlaylistModel> playlists;

	@OneToMany(mappedBy = "user")
	private List<PostModel> posts;

	@PrePersist
	@PreUpdate
	private void validate() {
		List<String> errors = new ArrayList<>();

		if (username == null || username.isEmpty()) {
			errors.add("Username is required.");
		}

		if (password == null || password.isEmpty()) {
			errors.add("Password is required.");
		} else if (password.length() < 8) {
			errors.add("Password must have at least 8 characters.");
		}

		if (email == null || email.isEmpty()) {
			errors.add("Email is required.");
		} else if (!isValidEmail(email)) {
			errors.add("Invalid email address.");
		}

		if (!errors.isEmpty()) {
			throw new IllegalArgumentException(errors.toString());
		}
	}

	private boolean isValidEmail(String email) {

		return email.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b");
	}
}
