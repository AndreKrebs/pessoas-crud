package com.andre.app.rest;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.app.domain.Dependent;
import com.andre.app.domain.dto.DependentNewDto;
import com.andre.app.domain.enums.DependentType;
import com.andre.app.service.DependentService;

@RestController
@RequestMapping("/api/dependent")
public class DependentController {

	@Autowired
	private DependentService dependentService;
	
	@GetMapping("/dependent-type")
	public ResponseEntity<Collection<?>> getAllDependentType() {
		Collection<?> dependentType = Collections.singletonList(DependentType.values());
		
		return ResponseEntity.ok().body(dependentType);
	}
	
	@GetMapping
	public ResponseEntity<List<Dependent>> getAllDependents() {
		
		List<Dependent> dependents = dependentService.getAllDependents();
		
		return ResponseEntity.ok().body(dependents);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dependent> getDependent(@PathVariable("id") Integer idDependent) {
		
		Dependent dependent = dependentService.getDependent(idDependent);
		
		return ResponseEntity.ok().body(dependent);
	}
	
	@PostMapping
	public ResponseEntity<Dependent> postDependent(@Valid @RequestBody DependentNewDto dependentObj) throws Exception {
		
		Dependent obj = new Dependent();
		
		obj = dependentService.newDependent(dependentObj);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDependent(@PathVariable("id") Integer idDependent) {
		
		dependentService.deleteDependent(idDependent);
		
		return ResponseEntity.noContent().build();
	}
	
}
