package com.example.NaRua.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
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
	private String username;
	private String password;
	private String email;
	
	@OneToMany(mappedBy = "user")
	private List<PlaylistModel> playlists;
	
	@OneToMany(mappedBy = "user")
	private List<PostModel> posts;

}
