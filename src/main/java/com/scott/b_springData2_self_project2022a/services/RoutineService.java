package com.scott.b_springData2_self_project2022a.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scott.b_springData2_self_project2022a.models.Competition;
import com.scott.b_springData2_self_project2022a.models.Party;
import com.scott.b_springData2_self_project2022a.models.Routine;
import com.scott.b_springData2_self_project2022a.repositories.RoutineRepository;

@Service
public class RoutineService {
	private final RoutineRepository routineRepository;
	public RoutineService(RoutineRepository routineRepository) {
		this.routineRepository=routineRepository;
	}
	public List<Routine> allRoutines(){
		return routineRepository.findAll();
	}
	public Routine findRoutine(Long id) {
		Optional<Routine> optional=routineRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public Routine createRoutine(Routine r) {
		return routineRepository.save(r);
	}
//	public Routine updateRoutine(Long id, String routineName, List<Competition> competitions, List<Group> groups) {
//		Routine r=findRoutine(id);
//		r.setRoutineName(routineName);
//		r.setCompetitions(competitions);
//		//r.setCompetition(competition);
//		r.setGroups(groups);
//		return routineRepository.save(r);
//	}
	public Routine updateRoutine(Long id, String routineName, List<Competition> competitions, List<Party> parties) {
		Routine r=findRoutine(id);
		r.setRoutineName(routineName);
		r.setCompetitions(competitions);
		//r.setCompetition(competition);
//		r.setGroups(groups);
		r.setParties(parties);
		return routineRepository.save(r);
	}
	public Routine updateRoutine(Routine r) {
		return routineRepository.save(r);
	}
	public void deleteRoutine(Long id) {
		routineRepository.deleteById(id);
	}
}
