package com.scott.b_springData2_self_project2022a.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scott.b_springData2_self_project2022a.models.Album;
import com.scott.b_springData2_self_project2022a.models.Music;
import com.scott.b_springData2_self_project2022a.models.User;
import com.scott.b_springData2_self_project2022a.repositories.AlbumRepository;

@Service
public class AlbumService {
	private final AlbumRepository albumRepository;
	public AlbumService(AlbumRepository albumRepository) {
		this.albumRepository=albumRepository;
	}
	public List<Album> allAlbums(){
		return albumRepository.findAll();
	}
	public Album findAlbum(Long id) {
		Optional<Album> optional = albumRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public Album createAlbum(Album a) {
		return albumRepository.save(a);
	}
	public Album updateAlbum(Long id, String title, User host, List<Music> musics) {
		Album a=findAlbum(id);
		a.setTitle(title);
		a.setHost(host);
		a.setMusics(musics);
		return albumRepository.save(a);
	}
	public Album updateAlbum(Album a) {
		return albumRepository.save(a);
	}
	public void deleteAlbum(Long id) {
		albumRepository.deleteById(id);
	}
}
