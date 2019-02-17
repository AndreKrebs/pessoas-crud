package com.andre.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.andre.app.domain.dto.DependentNewDto;
import com.andre.app.domain.enums.DependentType;
import com.andre.app.domain.object.Person;

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
	
	public Dependent(DependentNewDto peopleNewDto) {
		this.name = peopleNewDto.getName();
		this.email = peopleNewDto.getEmail();
		this.dateBird = peopleNewDto.getDateBird();
		this.dependentType = peopleNewDto.getDependentType();
		this.people = peopleNewDto.getPeople();
	}
	
//	@JsonIgnore
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
	
	
	
}
