package com.pack.dto;

public class ProductDTO {

	private Integer productId;
	private String productName;
	private Double price;
	private String manufacturer;
	public ProductDTO() {
		super();
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", manufacturer=" + manufacturer + "]";
	}


}
