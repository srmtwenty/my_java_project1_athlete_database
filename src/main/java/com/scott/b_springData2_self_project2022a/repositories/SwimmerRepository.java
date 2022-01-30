package com.scott.b_springData2_self_project2022a.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.scott.b_springData2_self_project2022a.models.Swimmer;

@Repository
public interface SwimmerRepository extends CrudRepository<Swimmer, Long>{
	List<Swimmer> findAll();
	List<Swimmer> findByNation_NameContaining(String nation);
	List<Swimmer> findByBirthYear(Integer birthYear);
	List<Swimmer> findByNameIgnoreCaseContaining(String name);
	//List<Swimmer> findByFirstnameAndLastnameContaining(String firstname, String lastname);
	Long countByNation_Id(Long id);
	List<Swimmer> findByOrderByBirthYearDesc();
}
