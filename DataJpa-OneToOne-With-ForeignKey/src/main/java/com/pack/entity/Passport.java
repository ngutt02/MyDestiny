package com.pack.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Passport {

	@Id
	private Integer passportId;
	@Temporal(TemporalType.DATE)
	private Date expDate;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="person_id_fk",unique=true,nullable=false)
	private Person person;
	public Passport() {
		super();
	}
	public Integer getPassportId() {
		return passportId;
	}
	public void setPassportId(Integer passportId) {
		this.passportId = passportId;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Passport [passportId=" + passportId + ", expDate=" + expDate + ", person=" + person + "]";
	}


}
