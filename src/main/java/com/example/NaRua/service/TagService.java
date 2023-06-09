package com.example.NaRua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.NaRua.Exception.NotFoundEntityException;
import com.example.NaRua.model.TagModel;
import com.example.NaRua.repository.TagRepository;
import java.util.List;

@Service
public class TagService {
	
	@Autowired
	private TagRepository tagRepository;
	
	public TagModel getTagById(Long id) throws NotFoundEntityException {
		return tagRepository.findById(id).orElseThrow(() -> 
		new NotFoundEntityException("Tag not Found"));
	}
	
	public List<TagModel> getAll() {
		return tagRepository.findAll();
	}
	
	public void deleteTag(Long id) { // Possible Exception
		tagRepository.deleteById(id);
	}
	
	public List<TagModel> getTagByName(String name) { // Possible Exception
		return tagRepository.findByName(name);
	}
	
	public TagModel createTag(TagModel tagModel) {
		return tagRepository.save(tagModel);
	}
}
