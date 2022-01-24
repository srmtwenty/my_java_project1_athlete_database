package com.scott.b_springData2_self_project2022a.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scott.b_springData2_self_project2022a.models.Competition;
import com.scott.b_springData2_self_project2022a.models.Music;
import com.scott.b_springData2_self_project2022a.models.Nation;
import com.scott.b_springData2_self_project2022a.models.Party;
import com.scott.b_springData2_self_project2022a.models.Routine;
import com.scott.b_springData2_self_project2022a.models.Swimmer;
import com.scott.b_springData2_self_project2022a.models.User;
import com.scott.b_springData2_self_project2022a.repositories.PartyRepository;

@Service
public class PartyService {
	private final PartyRepository partyRepository;
	public PartyService(PartyRepository partyRepository) {
		this.partyRepository=partyRepository;
	}
	public List<Party> allParties(){
		return partyRepository.findAll();
	}
	public Party findParty(Long id) {
		Optional<Party> optional=partyRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public Party createParty(Party p) {
		return partyRepository.save(p);
	}
	public Party updateParty(Long id, String partyName, String description, double score,String ranking, Routine routine, Nation nation, List<Swimmer> swimmers, List<Music> musics, Competition competition, User host, String coach) {
		Party p=findParty(id);
		p.setPartyName(partyName);
		p.setDescription(description);
		p.setScore(score);
		p.setRanking(ranking);
		p.setRoutine(routine);
		p.setNation(nation);
		p.setSwimmers(swimmers);
		p.setMusics(musics);
		p.setCompetition(competition);
		p.setHost(host);
		p.setCoach(coach);
		return partyRepository.save(p);
	}
	public Party updateParty(Party p) {
		return partyRepository.save(p);
	}
	public void deleteParty(Long id) {
		partyRepository.deleteById(id);
	}
}
