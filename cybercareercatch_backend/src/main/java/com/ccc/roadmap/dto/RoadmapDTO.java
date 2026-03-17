package com.ccc.roadmap.dto;

public class RoadmapDTO {
	   private int roadmapJobNumber;
	   private int jobNumber;
	   private String roadmapJobName;
	   
	   public int getRoadmapJobNumber() {
		return roadmapJobNumber;
	}
	   public void setRoadmapJobNumber(int roadmapJobNumber) {
		   this.roadmapJobNumber = roadmapJobNumber;
	   }
	   public int getJobNumber() {
		   return jobNumber;
	   }
	   public void setJobNumber(int jobNumber) {
		   this.jobNumber = jobNumber;
	   }
	   public String getRoadmapJobName() {
		   return roadmapJobName;
	   }
	   public void setRoadmapJobName(String roadmapJobName) {
		   this.roadmapJobName = roadmapJobName;
	   }
	   public String getRoadmapJobDesc() {
		   return roadmapJobDesc;
	   }
	   public void setRoadmapJobDesc(String roadmapJobDesc) {
		   this.roadmapJobDesc = roadmapJobDesc;
	   }
	   private String roadmapJobDesc;

	   @Override
	   public String toString() {
		return "RoadmapDTO [roadmapJobNumber=" + roadmapJobNumber + ", jobNumber=" + jobNumber + ", roadmapJobName="
				+ roadmapJobName + ", roadmapJobDesc=" + roadmapJobDesc + "]";
	   }
	   
}
