package com.ccc.post.dto;

public class CommentWriteDTO {
	  private int postNumber;
	  private int userNumber;
	  private String commentContent;
	  
	  
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
	  
	  
	  @Override
	  public String toString() {
		return "CommentWriteDTO [postNumber=" + postNumber + ", userNumber=" + userNumber + ", commentContent="
				+ commentContent + "]";
	  }
	  
	  

}
