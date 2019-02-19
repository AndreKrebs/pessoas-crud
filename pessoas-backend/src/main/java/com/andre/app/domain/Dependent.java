package com.andre.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.andre.app.domain.dto.DependentNewDto;
import com.andre.app.domain.enums.DependentType;
import com.andre.app.domain.object.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="dependent")
public class Dependent extends Person {
	
	@ManyToOne(targetEntity=People.class)
	@JoinColumn(referencedColumnName = "id", name="people_id")
	private People people;	
	
	@Column(nullable=false)
	private Integer dependentType;

	public Dependent() {
		super();
	}
	
	public Dependent(DependentNewDto peopleNewDto, People people) {
		this.id = peopleNewDto.getId();
		this.name = peopleNewDto.getName();
		this.email = peopleNewDto.getEmail();
		this.dateBirth = peopleNewDto.getDateBirth();
		this.dependentType = peopleNewDto.getDependentType();
		this.people = people;
	}
	
	@JsonIgnore
	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public DependentType getDependentType() {
		return DependentType.toEnum(this.dependentType);
	}

	public void setDependentType(Integer dependentType) {
		this.dependentType = dependentType;
	}

	@Override
	public String toString() {
		return "Dependent [people=" + people + ", dependentType=" + dependentType + "]";
	}
	
	
	
}
