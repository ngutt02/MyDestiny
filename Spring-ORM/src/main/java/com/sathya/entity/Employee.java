package com.sathya.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee {
	@Id
	private Integer empno;

	private String ename;

	private Double salary;

	private Integer deptno;

	public Employee() {
		super();
	}

	public Employee(Integer empno, String ename, Double salary, Integer deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
		this.deptno = deptno;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}


	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", salary=" + salary + ", deptno=" + deptno + "]";
	}





}
