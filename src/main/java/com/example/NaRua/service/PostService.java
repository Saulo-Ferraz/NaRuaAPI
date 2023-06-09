package com.example.NaRua.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.NaRua.Exception.NotFoundEntityException;
import com.example.NaRua.model.PostModel;
import com.example.NaRua.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<PostModel> getAllPost(){
		return postRepository.findAll();
	}
	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}
	
	public PostModel findById(Long id) throws NotFoundEntityException {
		return postRepository.findById(id).orElseThrow(() ->
		new NotFoundEntityException("Post not Found"));
	
	}
	public PostModel findByText(String text){ // Possible Exception
		return postRepository.findByText(text);
	}
	public PostModel createPost(PostModel postModel) {
		return postRepository.save(postModel);
	}
	
	public PostModel updatePost(String text, PostModel postModel) {
		PostModel existingPost = postRepository.findByText(text);
		existingPost.setText(postModel.getText());
		
		return postRepository.save(existingPost);
		
	}
}
