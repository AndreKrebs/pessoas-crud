package com.andre.app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.andre.app.domain.dto.PeopleNewDto;
import com.andre.app.domain.object.Person;

@Entity
@Table(name="people")
public class People extends Person {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "people", targetEntity=Dependent.class)
	private List<Dependent> dependents = new ArrayList<Dependent>();
	

	public People() {
		super();
	}
	
	public People(PeopleNewDto peopleNewDto) {
		this.name = peopleNewDto.getName();
		this.email = peopleNewDto.getEmail();
		this.dateBird = peopleNewDto.getDateBird();
	}
	
	
	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

	

}
