package com.ccc.post.dto;

public class CommentViewDTO {
	  private int commentNumber;
	  private int postNumber;
	  private int userNumber;
	  private String userId;
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
	  public String getUserId() {
		  return userId;
	  }
	  public void setUserId(String userId) {
		  this.userId = userId;
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
		return "CommentViewDTO [commentNumber=" + commentNumber + ", postNumber=" + postNumber + ", userNumber="
				+ userNumber + ", userId=" + userId + ", commentContent=" + commentContent + ", commentDate="
				+ commentDate + "]";
	  }
	  
	  
	  
	  
}
