package com.ccc.qna.dto;

public class QnaCommentDTO {
	   private int commentNumber;
	   private int postNumber;
	   private int userNumber;
	   private int companyNumber;
	   private String companyName;
	   private String commentContent;
	   private String commentDate;
	   
	   public int getCommentNumber() {
		   return commentNumber;
	   }
	   public void setCommentNumber(int commentNumber) {
		   this.commentNumber = commentNumber;
	   }
	   public int getPostNumber() {
		   return postNumber;
	   }
	   public void setPostNumber(int postNumber) {
		   this.postNumber = postNumber;
	   }
	   public int getUserNumber() {
		   return userNumber;
	   }
	   public void setUserNumber(int userNumber) {
		   this.userNumber = userNumber;
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
	   public String getCommentContent() {
		   return commentContent;
	   }
	   public void setCommentContent(String commentContent) {
		   this.commentContent = commentContent;
	   }
	   public String getCommentDate() {
		   return commentDate;
	   }
	   public void setCommentDate(String commentDate) {
		   this.commentDate = commentDate;
	   }
	   @Override
	   public String toString() {
		return "QnaCommentDTO [commentNumber=" + commentNumber + ", postNumber=" + postNumber + ", userNumber="
				+ userNumber + ", companyNumber=" + companyNumber + ", companyName=" + companyName + ", commentContent="
				+ commentContent + ", commentDate=" + commentDate + "]";
	   }
	   
}
