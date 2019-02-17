package com.andre.app.domain.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.andre.app.domain.People;

public class DependentNewDto {

	@NotEmpty(message = "Campo nome é obrigatório")
	private String name;
	
	@NotEmpty(message = "Campo email é obrigatório")
	@Email(message = "Campo não está no formato de e-mail")
	private String email;
	
//	@NotEmpty(message = "Campo Data de Nascimento é obrigatório")
	private LocalDate dateBird;
	
	@NotEmpty(message = "Campo Tipo de Dependente é obrigatório")
	private Integer dependentType;
	
	@NotEmpty(message = "Campo Dependente é obrigatório")
	private People people;	

	
	public DependentNewDto() {
		super();
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

	public LocalDate getDateBird() {
		return dateBird;
	}

	public void setDateBird(LocalDate dateBird) {
		this.dateBird = dateBird;
	}
	
	public Integer getDependentType() {
		return dependentType;
	}


	public void setDependentType(Integer dependentType) {
		this.dependentType = dependentType;
	}


	public People getPeople() {
		return people;
	}


	public void setPeople(People people) {
		this.people = people;
	}


	@Override
	public String toString() {
		return "DependentNewDto [name=" + name + ", email=" + email + ", dateBird=" + dateBird + ", dependentType="
				+ dependentType + ", people=" + people + "]";
	}
	
	
	
	
}
