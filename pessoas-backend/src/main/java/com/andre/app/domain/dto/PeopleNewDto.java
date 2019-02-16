package com.andre.app.domain.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class PeopleNewDto {

	private Integer id;
	
	private Integer peopleDependent;
	
	@NotEmpty(message = "Campo nome é obrigatório")
	private String name;
	
	@NotEmpty(message = "Campo email é obrigatório")
	@Email(message = "Campo não está no formato de e-mail")
	private String email;
	
//	@NotEmpty(message = "Campo Data de Nascimento é obrigatório")
	private Date dateBird;

	
	public PeopleNewDto() {
		super();
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPeopleDependent() {
		return peopleDependent;
	}

	public void setPeopleDependent(Integer peopleDependent) {
		this.peopleDependent = peopleDependent;
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

	public Date getDateBird() {
		return dateBird;
	}

	public void setDateBird(Date dateBird) {
		this.dateBird = dateBird;
	}
	
	
	
	
}
