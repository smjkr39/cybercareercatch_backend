package com.ccc.company.dto;

public class FileDTO {
	   private int fileNumber;
	   private String filePath;
	   private int companyNumber;
	   
	   public int getFileNumber() {
		   return fileNumber;
	   }
	   public void setFileNumber(int fileNumber) {
		   this.fileNumber = fileNumber;
	   }
	   public String getFilePath() {
		   return filePath;
	   }
	   public void setFilePath(String filePath) {
		   this.filePath = filePath;
	   }
	   public int getCompanyNumber() {
		   return companyNumber;
	   }
	   public void setCompanyNumber(int companyNumber) {
		   this.companyNumber = companyNumber;
	   }
	   @Override
	   public String toString() {
		return "FileDTO [fileNumber=" + fileNumber + ", filePath=" + filePath + ", companyNumber=" + companyNumber
				+ "]";
	   }
	   
}
