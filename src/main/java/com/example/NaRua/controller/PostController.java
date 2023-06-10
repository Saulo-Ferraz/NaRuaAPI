package com.example.NaRua.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.NaRua.Exception.NotFoundEntityException;
import com.example.NaRua.model.PostModel;
import com.example.NaRua.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ResponseEntity<PostModel> createPost
			(@RequestBody PostModel postModel) {
		   return ResponseEntity.status(HttpStatus.OK)
				   .body(postService.createPost(postModel));
		}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<List<PostModel>> readPost() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(postService.getAllPost());
		}
	
	@RequestMapping(value="/update/{postText}", method=RequestMethod.PUT)
	public ResponseEntity<PostModel> updatePost(
	@PathVariable(value = "postText") String text,
	@RequestBody PostModel postModel) throws NotFoundEntityException {
		return ResponseEntity.status(HttpStatus.OK)
				.body(postService.updatePost(text, postModel));
		}
	
	@RequestMapping(value="/delete/{postId}", method=RequestMethod.DELETE)
	public ResponseEntity<PostModel> deletePost(
	@PathVariable(value = "postId") Long id){
		postService.deletePost(id);
	return ResponseEntity.status(HttpStatus.OK).body(null);
		}
}
