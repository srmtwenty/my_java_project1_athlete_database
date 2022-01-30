package com.scott.b_springData2_self_project2022a.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scott.b_springData2_self_project2022a.models.Competition;
import com.scott.b_springData2_self_project2022a.models.Music;
import com.scott.b_springData2_self_project2022a.models.Nation;
import com.scott.b_springData2_self_project2022a.models.Party;
import com.scott.b_springData2_self_project2022a.models.Swimmer;
import com.scott.b_springData2_self_project2022a.models.User;
import com.scott.b_springData2_self_project2022a.repositories.SwimmerRepository;

@Service
public class SwimmerService {
	private final SwimmerRepository swimmerRepository;
	public SwimmerService(SwimmerRepository swimmerRepository) {
		this.swimmerRepository=swimmerRepository;
	}
	public List<Swimmer> allSwimmers(){
		return swimmerRepository.findAll();
	}
	public List<Swimmer> findByNation(String nation){
		return swimmerRepository.findByNation_NameContaining(nation);
	}
	public List<Swimmer> findByBirthYear(Integer birthYear){
		return swimmerRepository.findByBirthYear(birthYear);
	}
	public List<Swimmer> findByName(String name){
		return swimmerRepository.findByNameIgnoreCaseContaining(name);
	}
	//public List<Swimmer> findByFullName(String firstname, String lastname){
	//	return swimmerRepository.findByFirstnameAndLastnameContaining(firstname, lastname);
	//}
	public Long countByNation(Long id) {
		return swimmerRepository.countByNation_Id(id);
	}
	public List<Swimmer> findByOrderByBirthYearDesc(){
		return swimmerRepository.findByOrderByBirthYearDesc();
	}
	
	public Swimmer findSwimmer(Long id) {
		Optional<Swimmer> optional=swimmerRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public Swimmer createSwimmer(Swimmer s) {
		return swimmerRepository.save(s);
	}
//	public Swimmer updateSwimmer(Long id, String firstname, String lastname, int birthYear, List<Competition> competitions, Nation nation, List<Music> musics, List<Group> groups) {
//		Swimmer s=findSwimmer(id);
//		s.setFirstname(firstname);
//		s.setLastname(lastname);
//		s.setBirthYear(birthYear);
//		s.setCompetitions(competitions);
//		s.setNation(nation);
//		s.setMusics(musics);
//		s.setGroups(groups);
//		return swimmerRepository.save(s);
//	}
	public Swimmer updateSwimmer(Long id, String name, int birthYear, String photos, String description, List<Competition> competitions, Nation nation, List<Music> musics, User host, List<Party> parties) {
		Swimmer s=findSwimmer(id);
		s.setName(name);
		s.setBirthYear(birthYear);
		s.setPhotos(photos);
		s.setDescription(description);
		s.setCompetitions(competitions);
		s.setNation(nation);
		s.setMusics(musics);
		s.setHost(host);
		//s.setGroups(groups);
		s.setParties(parties);
		return swimmerRepository.save(s);
	}
	public Swimmer updateSwimmer(Swimmer s) {
		return swimmerRepository.save(s);
	}
	public void deleteSwimmer(Long id){
		swimmerRepository.deleteById(id);
	}
}