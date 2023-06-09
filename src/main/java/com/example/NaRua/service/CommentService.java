package com.example.NaRua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.NaRua.Exception.NotFoundEntityException;
import com.example.NaRua.model.CommentModel;
import com.example.NaRua.repository.CommentRepository;


@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public List<CommentModel> getAll(){
		return commentRepository.findAll();
	}
	
	public CommentModel getCommentById(Long id) throws NotFoundEntityException {
		return commentRepository.findById(id).orElseThrow(() -> 
		new NotFoundEntityException("Comment Not Found"));
	}
	
	public List<CommentModel> getCommentByText(String text){ // Possible Exception
		return commentRepository.findByText(text);
	}
	
	public CommentModel createComment(CommentModel commentModel) {
		return commentRepository.save(commentModel);
	}
	
	public void deleteComment(Long id) {
		commentRepository.deleteById(id);
	}
}
