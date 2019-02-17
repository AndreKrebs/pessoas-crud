package com.andre.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.app.domain.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {

//	@Query("SELECT dp FROM People dp WHERE dp.peopleDependent.id=:peopleId")
//	List<People> findAllDependents(@Param("peopleId") Integer peopleId);
	
	
//	@Query("SELECT p FROM People p JOIN p.peopleDependent dp WHERE p.peopleDependent.id=:peopleId AND p.peopleDependent=dp")
//	@Query("SELECT p FROM People p WHERE p.peopleDependent.id=:dependentPeopleId")
//	List<People> findPeopleDependents(@Param("dependentPeopleId")  Integer dependentPeopleId);
//	
//	List<People> findAllByPeopleDependentIsNull();

}
