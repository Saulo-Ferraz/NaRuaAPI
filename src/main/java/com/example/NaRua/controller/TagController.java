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
import com.example.NaRua.model.TagModel;
import com.example.NaRua.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ResponseEntity<TagModel> createTag
			(@RequestBody TagModel tagModel){
		return ResponseEntity.status(HttpStatus.OK)
				.body(tagService.createTag(tagModel));
		}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<List<TagModel>> readTag() {
			return ResponseEntity.status(HttpStatus.OK)
				.body(tagService.getAllTags());
		}
	
	@RequestMapping(value="/update/{tagName}", method=RequestMethod.PUT)
	public ResponseEntity<TagModel> updateTag(
	@PathVariable(value = "tagName") String name,
	@RequestBody TagModel tagModel) throws NotFoundEntityException {
		return ResponseEntity.status(HttpStatus.OK)
				.body(tagService.updateTag(name, tagModel));
			
		}
	
	@RequestMapping(value="/delete/{tagId}", method=RequestMethod.DELETE)
	public ResponseEntity<TagModel> deleteTag(
	@PathVariable(value = "tagId") Long id) {
		tagService.deleteTag(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
