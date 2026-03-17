package com.ccc.post.dto;

public class CommentDTO {
//    COMMENT_NUMBER   NUMBER,
//    POST_NUMBER      NUMBER NOT NULL,
//    USER_NUMBER      NUMBER NOT NULL,
//    COMMENT_CONTENT  VARCHAR2(4000) NOT NULL,
//    COMMENT_DATE     DATE DEFAULT SYSDATE NOT NULL

	  private int commentNumber;
	  private int postNumber;
	  private int userNumber;
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
		return "CommentDTO [commentNumber=" + commentNumber + ", postNumber=" + postNumber + ", userNumber="
				+ userNumber + ", commentContent=" + commentContent + ", commentDate=" + commentDate + "]";
	  }

	  
	  


}
