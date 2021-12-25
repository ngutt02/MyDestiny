package com.pack.bean;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductBean {


	private Integer productId;

	private String productName;

	private Double price;

	private String manufacturer;

	


}
