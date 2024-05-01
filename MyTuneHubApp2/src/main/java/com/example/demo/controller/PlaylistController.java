package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.PlayList;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayListService;
import com.example.demo.services.SongService;
@Controller
public class PlaylistController {
	@Autowired
	PlayListService pserv;
	@Autowired
	SongService sserv;
	@GetMapping("/createplaylist")
	public String createPlaylist(Model model) {
		//fetching the songs using song service
		List<Song> songslist=sserv.fetchAllSongs();
		//adding songs in the model
		model.addAttribute("songslist", songslist);
		//sending createplaylist
		return "createplaylist";
	}
	@PostMapping("/addplaylist")
	public String addPlayList(@ModelAttribute PlayList playlist) {
		//adding playlist
		pserv.addPlaylist(playlist);
		//update song table
		List<Song> songsList=playlist.getSongs();
		for(Song song :songsList) {
			song.getPlaylist().add(playlist);
			sserv.updateSong(song);
		}
		//songserv.addSongs(song);
		return "playlistsuccess";
	}
	@GetMapping("/viewPlaylist")
	public String viewPlayList(Model model) {
		List<PlayList> plist=pserv.fetchPlayLists();
		model.addAttribute("plist", plist);
		return "viewplaylist";
	}
	
}
