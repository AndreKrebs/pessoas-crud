package com.andre.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.app.domain.People;
import com.andre.app.domain.dto.PeopleNewDto;
import com.andre.app.repository.PeopleRepository;

@Service
public class PeopleService {

	@Autowired
	private PeopleRepository peopleRepository;
	
	public List<People> listPeople() {
		
		List<People> list = peopleRepository.findAll();
		
		return list;
		
	}

	public List<People> listPeopleByPeopleId(Integer idPeople) {
		List<People> list = peopleRepository.findAllDependents(idPeople);
		
		return list;
	}

	public People newPeople(PeopleNewDto peopleNewObj) throws Exception {
		
		if (peopleNewObj.getId()==null) {
			
			Optional<People> dependentObj = Optional.empty();
			
			if(peopleNewObj.getPeopleDependent() != null && peopleNewObj.getPeopleDependent() > 0) {
				dependentObj = peopleRepository.findById(peopleNewObj.getPeopleDependent());
			}
			
			People peopleObj = new People(peopleNewObj, dependentObj.get());
			
			return peopleRepository.save(peopleObj);
		}
		
		throw new Exception("ID não é nulo");
		
	}
	
public People updatePeople(PeopleNewDto peopleNewObj) throws Exception {
		
		if (peopleNewObj.getId()!=null && peopleNewObj.getId() > 0) {
			
			Optional<People> dependentObj = Optional.empty();
			
			if(peopleNewObj.getPeopleDependent() != null && peopleNewObj.getPeopleDependent() > 0) {
				dependentObj = peopleRepository.findById(peopleNewObj.getPeopleDependent());
			}
			
			People peopleObj = new People(peopleNewObj, dependentObj.get());
			
			return peopleRepository.save(peopleObj);
		}
		
		throw new Exception("ID não é nulo");
		
	}

	public Map<People,List<People>> getPeople(Integer idPeople) {
		
		Optional<People> people = peopleRepository.findById(idPeople);
		
		List<People> peopleDependents = peopleRepository.findPeopleDependents(idPeople);
		
		Map<People, List<People>> peopleAndDependents = new HashMap<People, List<People>>(); 
		
		peopleAndDependents.put(people.get(), peopleDependents);
		
		return peopleAndDependents;
	}

	public void deletePeople(@Valid PeopleNewDto peopleObj) {
		if (peopleObj.getId()!=null && peopleObj.getId() > 0) {
			
			People people = new People(peopleObj);
			
			peopleRepository.delete(people);
		}
	}

	public List<People> listPeopleAndDependents() {
		List<People> peopleAndDependents = peopleRepository.findAllByPeopleDependentIsNull();
		/*Map<People, List<People>> peopleAndDependents = new HashMap<People, List<People>>();
		List<People> peopleIsNotDependent = peopleRepository.findAllByPeopleDependentIsNull();
		
		
		for(People p : peopleIsNotDependent) {
			List<People> peopleDependents = peopleRepository.findPeopleDependents(p.getId());
			
			if(peopleDependents.size()>0) {
				peopleAndDependents.put(p, peopleDependents);
			} else {
				peopleAndDependents.put(p, null);
			}
		}*/
		
		return peopleAndDependents;
	}
	
}
