package com.example.NaRua.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class PostModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String text;
	private LocalDate date;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
	
	@OneToMany(mappedBy = "post")
	private List<TagModel> tags;
	
	@OneToMany(mappedBy = "post")
	private List<CommentModel> comments;
	

}
