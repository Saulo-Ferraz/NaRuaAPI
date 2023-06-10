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
import com.example.NaRua.model.PlaylistModel;
import com.example.NaRua.service.PlaylistService;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;
		
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ResponseEntity<PlaylistModel> createPlaylist
			   (@RequestBody PlaylistModel playlistModel) {
		return ResponseEntity.status(HttpStatus.OK).
				body(playlistService.createPlaylist(playlistModel));
		}
		
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<List<PlaylistModel>> readPlaylist() {
		return ResponseEntity.status(HttpStatus.OK)
		.body(playlistService.getAllPlaylist());

		}
		
	@RequestMapping(value="/update/{playlistName}", method=RequestMethod.PUT)
	public ResponseEntity<PlaylistModel> updatePlaylist(
	@PathVariable(value = "playlistName") String name,
	@RequestBody PlaylistModel playlistModel) throws NotFoundEntityException {
		return ResponseEntity.status(HttpStatus.OK)
		.body(playlistService.updatePlaylist(name, playlistModel));

		}
		
	@RequestMapping(value="/delete/{playlistId}", method=RequestMethod.DELETE)
	public ResponseEntity<PlaylistModel> deletePlaylist(
	@PathVariable(value = "playlistId") Long id) {
		playlistService.deletePlaylist(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		}
}
