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
import com.example.NaRua.model.CommentModel;
import com.example.NaRua.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ResponseEntity<CommentModel> createComment
		   	(@RequestBody CommentModel commentModel) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(commentService.createComment(commentModel));
		}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ResponseEntity<List<CommentModel>> readComment(){
		return ResponseEntity.status(HttpStatus.OK)
				.body(commentService.getAllComments());
		}
	
	@RequestMapping(value="/update/{commentText}",method=RequestMethod.PUT)
	public ResponseEntity<CommentModel> updateComment(
	@PathVariable(value = "commentText") String text,
	@RequestBody CommentModel commentModel) throws NotFoundEntityException {
		return ResponseEntity.status(HttpStatus.OK)
			.body(commentService.updateComment(text, commentModel));
				
		}
	
	@RequestMapping(value="/delete/{commentId}", method=RequestMethod.DELETE)
	public ResponseEntity<CommentModel> deleteComment(
	@PathVariable(value = "commentId") Long id) {
		commentService.deleteComment(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
