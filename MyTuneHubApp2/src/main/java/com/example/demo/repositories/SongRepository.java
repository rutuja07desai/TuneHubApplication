package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Song;
import com.example.demo.entities.Users;

public interface SongRepository extends JpaRepository<Song,Integer>{
	public Song findByName(String name);
}
