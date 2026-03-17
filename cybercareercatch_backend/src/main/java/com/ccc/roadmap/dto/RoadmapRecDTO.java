package com.ccc.roadmap.dto;

public class RoadmapRecDTO {
	   private int recNumber;
	   private int jobNumber;
	   private String recType;
	   private String recName;
	   
	   public int getRecNumber() {
		   return recNumber;
	   }
	   public void setRecNumber(int recNumber) {
		   this.recNumber = recNumber;
	   }
	   public int getJobNumber() {
		   return jobNumber;
	   }
	   public void setJobNumber(int jobNumber) {
		   this.jobNumber = jobNumber;
	   }
	   public String getRecType() {
		   return recType;
	   }
	   public void setRecType(String recType) {
		   this.recType = recType;
	   }
	   public String getRecName() {
		   return recName;
	   }
	   public void setRecName(String recName) {
		   this.recName = recName;
	   }
	   @Override
	   public String toString() {
		return "RoadmapRecDTO [recNumber=" + recNumber + ", jobNumber=" + jobNumber + ", recType=" + recType
				+ ", recName=" + recName + "]";
	   }
	   
}
