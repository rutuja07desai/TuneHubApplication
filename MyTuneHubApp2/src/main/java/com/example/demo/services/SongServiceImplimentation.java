package com.example.demo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;
@Service
public class SongServiceImplimentation implements SongService {
	@Autowired
	SongRepository songrepo;
	@Override
	public String addSongs(Song song) {
		// TODO Auto-generated method stub
		songrepo.save(song);
		return "song is added";
	}
	@Override
	public boolean songExists(String name) {
		// TODO Auto-generated method stub
		//Song song=
		if(songrepo.findByName(name)==null) {
			return false;
		}
		else {
			return true;
		}
		
	}
	@Override
	public List<Song> fetchAllSongs() {
		// TODO Auto-generated method stub
		List<Song> songlist=songrepo.findAll();
		return songlist;
	}
	@Override
	public void updateSong(Song song) {
		// TODO Auto-generated method stub
		songrepo.save(song);
	}

}

