package com.andre.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.app.domain.Dependent;
import com.andre.app.domain.dto.DependentNewDto;
import com.andre.app.repository.DependentRepository;

@Service
public class DependentService {

	@Autowired
	private DependentRepository dependentRepository;  
	
	public List<Dependent> getAllDependents() {
		return dependentRepository.findAll();
	}

	public Dependent getDependent(Integer idDependent) {
		return dependentRepository.findById(idDependent).orElse(null);
	}

	public Dependent newDependent(@Valid DependentNewDto dependentObj) {
		Dependent dependent = new Dependent(dependentObj);
		
		dependent = dependentRepository.save(dependent);
		
		return dependent;
	}

	public void deleteDependent(Integer idDependent) {
		dependentRepository.deleteById(idDependent);
		
	}

	
	
}
