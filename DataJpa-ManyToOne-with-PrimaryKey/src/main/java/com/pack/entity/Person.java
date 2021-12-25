package com.pack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	private Integer persomId;

	private String personName;



	public Person() {
		super();
	}



	public Integer getPersomId() {
		return persomId;
	}



	public void setPersomId(Integer persomId) {
		this.persomId = persomId;
	}



	public String getPersonName() {
		return personName;
	}



	public void setPersonName(String personName) {
		this.personName = personName;
	}



	@Override
	public String toString() {
		return "Person [persomId=" + persomId + ", personName=" + personName + "]";
	}





}
