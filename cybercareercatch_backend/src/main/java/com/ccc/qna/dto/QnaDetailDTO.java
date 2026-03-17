package com.ccc.qna.dto;

public class QnaDetailDTO {

	    private int postNumber;
	    private String postTitle;
	    private String postContent;
	    private int companyNumber;
	    private String companyName;
	    private int userNumber;
	    private String userId;
	    private String userName;
	    private String postDate;
	    private int viewCount;
	    private String answerStatus;
		public int getPostNumber() {
			return postNumber;
		}
		public void setPostNumber(int postNumber) {
			this.postNumber = postNumber;
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
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPostDate() {
			return postDate;
		}
		public void setPostDate(String postDate) {
			this.postDate = postDate;
		}
		public int getViewCount() {
			return viewCount;
		}
		public void setViewCount(int viewCount) {
			this.viewCount = viewCount;
		}
		public String getAnswerStatus() {
			return answerStatus;
		}
		public void setAnswerStatus(String answerStatus) {
			this.answerStatus = answerStatus;
		}
		@Override
		public String toString() {
			return "QnaDetailDTO [postNumber=" + postNumber + ", postTitle=" + postTitle + ", postContent="
					+ postContent + ", companyNumber=" + companyNumber + ", companyName=" + companyName
					+ ", userNumber=" + userNumber + ", userId=" + userId + ", userName=" + userName + ", postDate="
					+ postDate + ", viewCount=" + viewCount + ", answerStatus=" + answerStatus + "]";
		}

	    
	    
	}
