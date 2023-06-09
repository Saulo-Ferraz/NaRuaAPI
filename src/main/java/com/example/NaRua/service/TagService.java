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
	
	public List<TagModel> getAllTags() {
		return tagRepository.findAll();
	}
	
	public void deleteTag(Long id) { // Possible Exception
		tagRepository.deleteById(id);
	}
	
	public TagModel getTagByName(String name) { // Possible Exception
		return tagRepository.findByName(name);
	}
	
	public TagModel createTag(TagModel tagModel) {
		return tagRepository.save(tagModel);
	}
	
	public TagModel updateTag(String name, TagModel tagModel) {
		TagModel existingTag = tagRepository.findByName(name);
		existingTag.setName(tagModel.getName());
		
		return tagRepository.save(existingTag);
	}
}
