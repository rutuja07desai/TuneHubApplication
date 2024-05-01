package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;

public interface PlayListService {
	String addPlaylist(PlayList playlist);

	List<PlayList> fetchPlayLists();
}
