package com.scott.b_springData2_self_project2022a.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scott.b_springData2_self_project2022a.models.Composer;
import com.scott.b_springData2_self_project2022a.models.Music;
import com.scott.b_springData2_self_project2022a.models.User;
import com.scott.b_springData2_self_project2022a.repositories.ComposerRepository;

@Service
public class ComposerService {
	private final ComposerRepository composerRepository;
	public ComposerService(ComposerRepository composerRepository) {
		this.composerRepository=composerRepository;
	}
	public List<Composer> allComposers(){
		return composerRepository.findAll();
	}
	public Composer findComposer(Long id) {
		Optional<Composer> optional=composerRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public Composer createComposer(Composer c) {
		return composerRepository.save(c);
	}
	public Composer updateComposer(Long id, String name, User host, List<Music> musics) {
		Composer c=findComposer(id);
		c.setName(name);
		c.setHost(host);
		c.setMusics(musics);
		return composerRepository.save(c);
	}
	public Composer updateComposer(Composer c) {
		return composerRepository.save(c);
	}
	public void deleteComposer(Long id) {
		composerRepository.deleteById(id);
	}
}
