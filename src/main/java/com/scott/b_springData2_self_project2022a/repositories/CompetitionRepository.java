package com.scott.b_springData2_self_project2022a.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scott.b_springData2_self_project2022a.models.Competition;

@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Long>{
	List<Competition> findAll();
	List<Competition> findByOrderByYearDesc();
	List<Competition> findByOrderByYearAsc();
	//List<Competition> search(String keyword);
}
