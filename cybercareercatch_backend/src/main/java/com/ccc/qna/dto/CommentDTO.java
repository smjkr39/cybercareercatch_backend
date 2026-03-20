package com.ccc.qna.dto;

public class CommentDTO {
	private Long commentNumber;
	private Long postNumber;
	private Long userNumber;
	private String memberId;
	private String commentContent;
	private String commentCreatedDate;
	
	public CommentDTO() {;}

	public Long getCommentNumber() {
		return commentNumber;
	}

	public void setCommentNumber(Long commentNumber) {
		this.commentNumber = commentNumber;
	}

	public Long getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(Long postNumber) {
		this.postNumber = postNumber;
	}

	public Long getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(Long userNumber) {
		this.userNumber = userNumber;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentCreatedDate() {
		return commentCreatedDate;
	}

	public void setCommentCreatedDate(String commentCreatedDate) {
		this.commentCreatedDate = commentCreatedDate;
	}

	@Override
	public String toString() {
		return "CommentDTO [commentNumber=" + commentNumber + ", postNumber=" + postNumber + ", userNumber="
				+ userNumber + ", memberId=" + memberId + ", commentContent=" + commentContent
				+ ", commentCreatedDate=" + commentCreatedDate + "]";
	}
}