package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PASSENGER")
@NamedQueries({@NamedQuery(name="Passenger.byFirstName", query="select passenger from Passenger passenger where passenger.firstName like '%a%' "),
	@NamedQuery(name="Passenger.byLastName",query="select passenger from Passenger passenger where passenger.lastName like '%a%'"),	
	@NamedQuery(name="Passenger.byEmailId",query="select passenger from Passenger passenger where passenger.emialId=:begin"),
	@NamedQuery(name="Passenger.byEmailId1",query="select passenger from Passenger passenger where passenger.emialId like '%gmail%' "),
	/*@NamedQuery(name="Passenger.byAgeSql",query="select * from passenger where age=25",nativeQuery=true)*/
})
public class Passenger {
	@Id
	Integer passengerId;

	String firstName;

	String lastName;

	String emialId;

	String gender;

	Integer age;

	Integer seatNumber;

	public Passenger() {
		super();
	}

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmialId() {
		return emialId;
	}

	public void setEmialId(String emialId) {
		this.emialId = emialId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emialId=" + emialId + ", gender=" + gender + ", age=" + age + ", seatNumber=" + seatNumber + "]";
	}




}
