package com.pack.dto;

import java.util.Date;

public class LoanDto {

	private String loanType;
	private Double loanAmount;
	private Date date;
	private Integer loanNumber;
	private String proprtyAddress;
	public LoanDto() {
		super();
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
	public Integer getLoanNumber() {
		return loanNumber;
	}
	public void setLoanNumber(Integer loanNumber) {
		this.loanNumber = loanNumber;
	}
	public String getProprtyAddress() {
		return proprtyAddress;
	}
	public void setProprtyAddress(String proprtyAddress) {
		this.proprtyAddress = proprtyAddress;
	}
	@Override
	public String toString() {
		return "LoanDto [loanType=" + loanType + ", loanAmount=" + loanAmount + ", date=" + date + ", loanNumber="
				+ loanNumber + ", proprtyAddress=" + proprtyAddress + "]";
	}
		
}
