package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

@Controller
public class SongsController {
	@Autowired
	SongService songserv;
	@PostMapping("/addsongs")
	public String addSongs(@ModelAttribute Song song) {
		boolean status=songserv.songExists(song.getName());
		if(status==false) {
			songserv.addSongs(song);
			return "songsuccess";
		}
		else {
			return "songfail";
		}
		
	}
	@GetMapping("/map-viewsongs")
	public String viewSong(Model model) {
		List<Song> songlist=songserv.fetchAllSongs();
		model.addAttribute("songlist",songlist);
		//System.out.println(songlist);
		return "displaysongs";
	}
	@GetMapping("/viewsongs")
	String viewCustomerSongs(Model model) {
		boolean primeCustomer =true;
		if(primeCustomer==true) {
			List<Song> songlist=songserv.fetchAllSongs();
			model.addAttribute("songlist",songlist);
			//System.out.println(songlist);
			return "displaysongs";
		}
		return "makepayment";
	}
}

