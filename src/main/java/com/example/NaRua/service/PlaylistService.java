package com.example.NaRua.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.NaRua.model.PlaylistModel;
import com.example.NaRua.repository.PlaylistRepository;
import com.example.NaRua.Exception.NotFoundEntityException;

@Service
public class PlaylistService {

	@Autowired
	private PlaylistRepository playlistRepository;
	
	public List<PlaylistModel> getAllPlaylist() {
		return playlistRepository.findAll();
	}
	
	public PlaylistModel getPlaylistById(Long id) throws NotFoundEntityException {
		return playlistRepository.findById(id).orElseThrow(() -> 
		new NotFoundEntityException("Playlist not Found"));
	}
	
	public PlaylistModel getByName(String name) { // Possible Exception
		return playlistRepository.findByName(name);
	}
	
	public void deletePlaylist(Long id) { // Possible Exception
		playlistRepository.deleteById(id);
	}
	
	public PlaylistModel createPlaylist(PlaylistModel playlistModel) {
		return playlistRepository.save(playlistModel);
	}
	
	public PlaylistModel updatePlaylist(String name, PlaylistModel playlistModel) {
		PlaylistModel existingPlaylist = playlistRepository.findByName(name);	
		existingPlaylist.setName(playlistModel.getName());
		
		return playlistRepository.save(existingPlaylist);
	}
}
