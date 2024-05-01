package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;
import com.example.demo.repositories.PlaylistRepository;

@Service
public class PlayListServiceImplementation implements PlayListService {
	@Autowired	
	PlaylistRepository prepo;

	@Override
	public String addPlaylist(PlayList playlist) {
		// TODO Auto-generated method stub
		prepo.save(playlist);
		return null;
	}

	@Override
	public List<PlayList> fetchPlayLists() {
		// TODO Auto-generated method stub
		return prepo.findAll();
		 
	}
}
