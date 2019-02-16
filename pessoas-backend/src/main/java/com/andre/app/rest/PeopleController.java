package com.andre.app.rest;

import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andre.app.domain.People;
import com.andre.app.domain.dto.PeopleNewDto;
import com.andre.app.service.PeopleService;
import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

	@Autowired
	private PeopleService peopleService;
	
	@GetMapping
	@JsonFormat
	public ResponseEntity<List<People>> listPeople() {
		
		List<People> list = peopleService.listPeople();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/dependents")
	public ResponseEntity<List<People>> listPeopleAndDependents() {
		
		List<People> list = peopleService.listPeopleAndDependents();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<People,List<People>>> getPeople(@PathVariable("id") Integer idPeople) {
		
		Map<People,List<People>> people = peopleService.getPeople(idPeople);
		
		return ResponseEntity.ok().body(people);
	}
	
	@GetMapping("/dependent/{id}")
	public ResponseEntity<List<People>> listPeopleDependent(@PathVariable("id") Integer idPeople) {
		
		List<People> list = peopleService.listPeopleByPeopleId(idPeople);
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Void> newPeople(@Valid @RequestBody PeopleNewDto peopleObj) throws Exception {
		
		People obj = new People();
		
		obj = peopleService.newPeople(peopleObj);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<Void> updatePeople(@Valid @RequestBody PeopleNewDto peopleObj) throws Exception {
		
		People obj = new People();
		
		obj = peopleService.updatePeople(peopleObj);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deletePeople(@Valid @RequestBody PeopleNewDto peopleObj) throws Exception {
		
		peopleService.deletePeople(peopleObj);
		
		return ResponseEntity.noContent().build();
	}
	
}
