package com.pack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Data
@Getter
@Setter
public class Employee {


	@Id
	private Integer id;
	private String ename;




}
