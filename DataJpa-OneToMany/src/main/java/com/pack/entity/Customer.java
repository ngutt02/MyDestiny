package com.pack.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	private Integer custId;
	@Column(length=25)
	private String custName;
	private Long mobile;
	
	
   
	@OneToMany(cascade=CascadeType.ALL,/*mappedBy="customer"*/orphanRemoval=true,fetch=FetchType.EAGER)
	@JoinColumn(name="custid_fk"/*,referencedColumnName="cust_id"*/)
	private Set<Order> orders;
	public Customer() {
		super();
	}
	public Customer(Integer custId, String custName, Long mobile) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.mobile = mobile;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", mobile=" + mobile + ", orders=" + orders
				+ "]";
	}	

}
