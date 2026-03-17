package com.ccc.qna.dto;

public class QnaListDTO {
	    private int postNumber;
	    private String postTitle;
	    private String companyName;
	    private String userId;
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
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
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
			return "QnaListDTO [postNumber=" + postNumber + ", postTitle=" + postTitle + ", companyName=" + companyName
					+ ", userId=" + userId + ", postDate=" + postDate + ", viewCount=" + viewCount + ", answerStatus="
					+ answerStatus + "]";
		}
		



	    
}
