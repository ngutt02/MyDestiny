package com.pack.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Order {
	@Id
	private Integer orderId;
	@Column(length=25)
	private String itemName;
	private Double price;
	/*@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="custid_fk")
	private Customer customer;*/
	public Order() {
		super();
	}

	public Order(Integer orderId, String itemName, Double price) {
		super();
		this.orderId = orderId;
		this.itemName = itemName;
		this.price = price;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", itemName=" + itemName + ", price=" + price + "]";
	}
	



	/*public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
*/
	


}
