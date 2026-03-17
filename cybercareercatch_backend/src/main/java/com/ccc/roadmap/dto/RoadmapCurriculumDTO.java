package com.ccc.roadmap.dto;

public class RoadmapCurriculumDTO {
	   private int jobNumber;
	   private String roadmapImagePath;
	   
	   public int getJobNumber() {
		   return jobNumber;
	   }
	   public void setJobNumber(int jobNumber) {
		   this.jobNumber = jobNumber;
	   }
	   public String getRoadmapImagePath() {
		   return roadmapImagePath;
	   }
	   public void setRoadmapImagePath(String roadmapImagePath) {
		   this.roadmapImagePath = roadmapImagePath;
	   }
	   @Override
	   public String toString() {
		return "RoadmapCurriculumDTO [jobNumber=" + jobNumber + ", roadmapImagePath=" + roadmapImagePath + "]";
	   }
	   
	   
}
