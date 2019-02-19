package com.andre.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.app.domain.Dependent;
import com.andre.app.domain.People;
import com.andre.app.domain.dto.DependentNewDto;
import com.andre.app.repository.DependentRepository;
import com.andre.app.repository.PeopleRepository;

@Service
public class DependentService {

	@Autowired
	private DependentRepository dependentRepository;  
	
	@Autowired
	private PeopleRepository peopleRepository;  
	
	public List<Dependent> getAllDependents() {
		return dependentRepository.findAll();
	}

	public Dependent getDependent(Integer idDependent) {
		return dependentRepository.findById(idDependent).orElse(null);
	}

	public Dependent newDependent(DependentNewDto dependentObj) throws Exception {
		People people = new People();
		
		if(dependentObj.getPeopleId() > 0) {
			people = peopleRepository.findById(dependentObj.getPeopleId()).orElse(null);
		
			Dependent dependent = new Dependent(dependentObj, people);
			
			dependent = dependentRepository.save(dependent);
		
			return dependent;
		}
		
		throw new Exception("Não foi informado o ID de Pessoa");
	}
	
	public Dependent updateDependent(DependentNewDto dependentObj) throws Exception {
		return newDependent(dependentObj);
	}

	public void deleteDependent(Integer idDependent) {
		dependentRepository.deleteById(idDependent);
	}


	
	
}
