package com.scott.b_springData2_self_project2022a.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scott.b_springData2_self_project2022a.models.Nation;
import com.scott.b_springData2_self_project2022a.models.Party;
import com.scott.b_springData2_self_project2022a.models.Swimmer;
import com.scott.b_springData2_self_project2022a.repositories.NationRepository;

@Service
public class NationService {
	private final NationRepository nationRepository;
	public NationService(NationRepository nationRepository) {
		this.nationRepository=nationRepository;
	}
	public List<Nation> allNations(){
		return nationRepository.findAll();
	}
	public Nation findNation(Long id) {
		Optional<Nation> optional=nationRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public Nation createNation(Nation n) {
		return nationRepository.save(n);
	}
//	public Nation updateNation(Long id, String name, List<Swimmer> swimmers, List<Group> groups) {
//		Nation n=findNation(id);
//		n.setName(name);
//		n.setSwimmers(swimmers);
//		//n.setParticipatedComps(participatedComps);
//		n.setGroups(groups);
//		return nationRepository.save(n);
//	}
	public Nation updateNation(Long id, String name, List<Swimmer> swimmers, List<Party> parties) {
		Nation n=findNation(id);
		n.setName(name);
		n.setSwimmers(swimmers);
		//n.setParticipatedComps(participatedComps);
		n.setParties(parties);
		return nationRepository.save(n);
	}
	public Nation updateNation(Nation n) {
		return nationRepository.save(n);
	}
	public void deleteNation(Long id) {
		nationRepository.deleteById(id);
	}
}
