package com.ccc.qna.dto;

public class QnaWriteDTO {
    private int userNumber;
    private int companyNumber;
    private String postTitle;
    private String postContent;
    
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
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	@Override
	public String toString() {
		return "QnaWriteDTO [userNumber=" + userNumber + ", companyNumber=" + companyNumber + ", postTitle=" + postTitle
				+ ", postContent=" + postContent + "]";
	}
	

    

}
