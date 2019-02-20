package com.andre.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.app.domain.People;
import com.andre.app.domain.dto.PeopleNewDto;
import com.andre.app.repository.DependentRepository;
import com.andre.app.repository.PeopleRepository;

@Service
public class PeopleService {

	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private DependentService dependentService;

	public List<People> listPeople() {
		return peopleRepository.findAll();
	}

	public People getPeople(Integer idPeople) {
		return peopleRepository.findById(idPeople).orElse(null);
	}

	public People newPeople(PeopleNewDto peopleNew) {
		
		People people = new People(peopleNew);
		
		System.out.println(people.toString());
		
		People newPeople = peopleRepository.save(people);
		
		return newPeople;
	}
	
	public People updatePeople(People peopleUpdate) {
		System.out.println("333333");
		return peopleRepository.save(peopleUpdate);
	}

	public void deletePeople(Integer idPeople) {
		
		dependentService.deleteDependentByPeople(idPeople);
		
		peopleRepository.deleteById(idPeople);
	}
	
	
}
