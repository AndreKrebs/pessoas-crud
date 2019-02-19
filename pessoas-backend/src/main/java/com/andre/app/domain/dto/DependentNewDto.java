package com.andre.app.domain.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import com.andre.app.domain.Dependent;

public class DependentNewDto {

	private Integer id;
	
	@NotEmpty(message = "Campo nome é obrigatório")
	private String name;
	
	@NotEmpty(message = "Campo email é obrigatório")
	@Email(message = "Campo não está no formato de e-mail")
	private String email;
	
	@Past(message="Data de nascimento não pode ser uma data futura")
	private LocalDate dateBirth;
	
	@Min(value=0, message = "Campo Tipo de Dependente é obrigatório")
	private Integer dependentType;
	
	@Min(value=1, message = "Campo Dependente é obrigatório")
	private Integer peopleId;	

	
	public DependentNewDto() {
		super();
	}

	public DependentNewDto(Dependent dependent) {
		this.id = dependent.getId();
		this.name = dependent.getName();
		this.email = dependent.getEmail();
		this.dateBirth = dependent.getDateBirth();
		this.dependentType = dependent.getDependentType();
		this.peopleId = dependent.getPeople().getId();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}
	
	public Integer getDependentType() {
		return dependentType;
	}


	public void setDependentType(Integer dependentType) {
		this.dependentType = dependentType;
	}


	public Integer getPeopleId() {
		return peopleId;
	}


	public void setPeopleId(Integer people) {
		this.peopleId = people;
	}


	@Override
	public String toString() {
		return "DependentNewDto [name=" + name + ", email=" + email + ", dateBirth=" + dateBirth + ", dependentType="
				+ dependentType + ", people=" + peopleId + "]";
	}
	
	
	
	
}
