package com.scott.b_springData2_self_project2022a.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scott.b_springData2_self_project2022a.models.Album;
import com.scott.b_springData2_self_project2022a.models.Composer;
import com.scott.b_springData2_self_project2022a.models.Music;
import com.scott.b_springData2_self_project2022a.models.Party;
import com.scott.b_springData2_self_project2022a.models.User;
import com.scott.b_springData2_self_project2022a.repositories.MusicRepository;

@Service
public class MusicService {
	private final MusicRepository musicRepository;
	public MusicService(MusicRepository musicRepository) {
		this.musicRepository=musicRepository;
	}
	public List<Music> allMusic(){
		return musicRepository.findAll();
	}
	public Music findMusic(Long id) {
		Optional<Music> optional=musicRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public Music createMusic(Music m) {
		return musicRepository.save(m);
	}
	public Music updateMusic(Long id, String title, Composer composer, String description, Album album, String performer, User host, List<Party> parties) {
		Music m=findMusic(id);
		m.setTitle(title);
		m.setComposer(composer);
		m.setDescription(description);
		m.setParties(parties);
		//m.setSwimmers(swimmers);
		m.setAlbum(album);
		m.setPerformer(performer);
		m.setHost(host);
		return musicRepository.save(m);
	}
	public Music updateMusic(Music m) {
		return musicRepository.save(m);
	}
	public void deleteMusic(Long id) {
		musicRepository.deleteById(id);
	}
}
