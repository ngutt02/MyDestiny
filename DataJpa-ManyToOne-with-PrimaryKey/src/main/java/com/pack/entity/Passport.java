package com.pack.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="passport1")
public class Passport {

	@GenericGenerator(name="f1",strategy="foreign",parameters=@Parameter(name="property",value="person"))

	@Id
	@GeneratedValue(generator="f1")
	private Integer passportId;
	@Temporal(TemporalType.DATE)
	private Date expDate;
	@OneToOne(cascade=CascadeType.ALL)
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
