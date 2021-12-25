package com.pack.entity;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="Loan")
public class LoanEntity {

	@Id
	private Integer loanNumber;
	private String loanType;
	private Double loanAmount;
	
	private Date date;
	
	private String status="pending";
	
	private String proprtyAddress;

	public LoanEntity() {
		super();
	}

	public Integer getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(Integer loanNumber) {
		this.loanNumber = loanNumber;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProprtyAddress() {
		return proprtyAddress;
	}

	public void setProprtyAddress(String proprtyAddress) {
		this.proprtyAddress = proprtyAddress;
	}

	@Override
	public String toString() {
		return "LoanEntity [loanNumber=" + loanNumber + ", loanType=" + loanType + ", loanAmount=" + loanAmount
				+ ", date=" + date + ", status=" + status + ", proprtyAddress=" + proprtyAddress + "]";
	}

	


}
