package com.ccc.expo.dto;

public class ExpoDetailDTO {
	   private int expoNumber;
	   private int expoName;
	   private String startDate;
	   private String endDate;
	   private String location;
	   private String regDate;
	   private int companyNumber;
	   private String companyName;
	   public int getExpoNumber() {
		   return expoNumber;
	   }
	   public void setExpoNumber(int expoNumber) {
		   this.expoNumber = expoNumber;
	   }
	   public int getExpoName() {
		   return expoName;
	   }
	   public void setExpoName(int expoName) {
		   this.expoName = expoName;
	   }
	   public String getStartDate() {
		   return startDate;
	   }
	   public void setStartDate(String startDate) {
		   this.startDate = startDate;
	   }
	   public String getEndDate() {
		   return endDate;
	   }
	   public void setEndDate(String endDate) {
		   this.endDate = endDate;
	   }
	   public String getLocation() {
		   return location;
	   }
	   public void setLocation(String location) {
		   this.location = location;
	   }
	   public String getRegDate() {
		   return regDate;
	   }
	   public void setRegDate(String regDate) {
		   this.regDate = regDate;
	   }
	   public int getCompanyNumber() {
		   return companyNumber;
	   }
	   public void setCompanyNumber(int companyNumber) {
		   this.companyNumber = companyNumber;
	   }
	   public String getCompanyName() {
		   return companyName;
	   }
	   public void setCompanyName(String companyName) {
		   this.companyName = companyName;
	   }
	   
	   @Override
	   public String toString() {
		return "ExpoDetailDTO [expoNumber=" + expoNumber + ", expoName=" + expoName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", location=" + location + ", regDate=" + regDate + ", companyNumber="
				+ companyNumber + ", companyName=" + companyName + "]";
	   }
	   
	   
	   
}
