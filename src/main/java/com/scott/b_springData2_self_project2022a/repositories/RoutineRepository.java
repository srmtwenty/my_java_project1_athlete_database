package com.scott.b_springData2_self_project2022a.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scott.b_springData2_self_project2022a.models.Routine;

@Repository
public interface RoutineRepository extends CrudRepository<Routine, Long>{
	List<Routine> findAll();
}
