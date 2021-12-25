package com.pack.dto;

public class UserDto {
	private String name;
	private String userName;
	private String password;
	private String address;
	private String state;
	private String country;
	private String email;                                                                                              
	private String role;  
	public UserDto() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
       
	public void setEmail(String email) {
		this.email = email;
	}    
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", userName=" + userName + ", password=" + password + ", address=" + address
				+ ", state=" + state + ", country=" + country + ", email=" + email + ", role=" + role + "]";
	}

	
	


	


}
