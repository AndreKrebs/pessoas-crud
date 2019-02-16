package com.andre.app.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.andre.app.domain.dto.PeopleNewDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="people")
public class People {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "peopleDependent")
	List<People > categoryList = new ArrayList<People>();
	
	@ManyToOne(targetEntity=People.class)
	@JoinColumn(referencedColumnName = "id",name="people_id")
	private People peopleDependent;
	
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false, unique=true)
	@Email
	private String email;
	
	@Column(nullable=false)
	private Date dateBird;
	
	

	public People() {
		super();
	}
	
	public People(PeopleNewDto peopleDto, People peopleDependent) {
		
		this.peopleDependent = peopleDependent;
		this.name = peopleDto.getName();
		this.email = peopleDto.getEmail();
		this.dateBird = peopleDto.getDateBird();
	}
	
	public People(PeopleNewDto peopleDto) {
		this.peopleDependent = null;
		this.name = peopleDto.getName();
		this.email = peopleDto.getEmail();
		this.dateBird = peopleDto.getDateBird();
	}

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<People> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<People> categoryList) {
		this.categoryList = categoryList;
	}

	@JsonIgnore
	public People getPeopleDependent() {
		return peopleDependent;
	}

	public void setPeopleDependent(People peopleDependent) {
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

	@Override
	public String toString() {
		return "People [id=" + id + ", peopleDependent=" + peopleDependent + ", name=" + name + ", email=" + email
				+ ", dateBird=" + dateBird + "]";
	}
	
	
	
}
