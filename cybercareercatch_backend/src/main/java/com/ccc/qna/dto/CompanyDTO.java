package com.ccc.qna.dto;

public class CompanyDTO {
	private Long companyNumber;
	private String companyName;

	public CompanyDTO() {;}

	public Long getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(Long companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}