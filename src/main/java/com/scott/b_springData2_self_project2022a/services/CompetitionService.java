package com.scott.b_springData2_self_project2022a.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scott.b_springData2_self_project2022a.models.Competition;
import com.scott.b_springData2_self_project2022a.models.Party;
import com.scott.b_springData2_self_project2022a.models.User;
import com.scott.b_springData2_self_project2022a.repositories.CompetitionRepository;

@Service
public class CompetitionService {
	private final CompetitionRepository competitionRepository;
	public CompetitionService(CompetitionRepository competitionRepository) {
		this.competitionRepository=competitionRepository;
	}
	public List<Competition> allCompetitions(){
		return competitionRepository.findAll();
	}
	public List<Competition> findByOrderByYearDesc(){
		return competitionRepository.findByOrderByYearDesc();
	}
	public List<Competition> findByOrderByYearAsc(){
		return competitionRepository.findByOrderByYearAsc();
	}
	//public List<Competition> search(String keyword){
	//	if(keyword!=null) {
	//		return competitionRepository.search(keyword);
	//	}
	//	return competitionRepository.findAll();
	//}
	public Competition findCompetition(Long id) {
		Optional<Competition> optional=competitionRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public Competition createCompetition(Competition c) {
		return competitionRepository.save(c);
	}
	public Competition updateCompetition(Long id, String name, String description, String location, int year, String eventType, List<Party> parties, User host) {
		Competition c=findCompetition(id);
		c.setName(name);
		c.setDescription(description);
		c.setLocation(location);
		c.setYear(year);
		//c.setRoutine(routine);
		c.setEventType(eventType);
		c.setParties(parties);
		c.setHost(host);
		return competitionRepository.save(c);
	}
	public Competition updateCompetition(Competition c) {
		return competitionRepository.save(c);
	}
	public void deleteCompetition(Long id) {
		competitionRepository.deleteById(id);
	}
}
