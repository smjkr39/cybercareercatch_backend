<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
if (session.getAttribute("adminNumber") == null) {
   response.sendRedirect(request.getContextPath() + "/admin/login.adfc");
   return;
}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>기업 QnA 상세</title>
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/assets/css/admin/main-management/company-qna.css">

<style>
.qna-detail-wrap {
   width: 100%;
   background: #fff;
   border-radius: 10px;
   padding: 30px;
   box-sizing: border-box;
}

.qna-detail-title {
   font-size: 28px;
   font-weight: bold;
   margin-bottom: 30px;
   color: #222;
}

.qna-detail-box {
   border: 1px solid #d9d9d9;
   border-radius: 10px;
   padding: 25px;
   margin-bottom: 25px;
   background: #fafafa;
}

.qna-detail-row {
   display: flex;
   gap: 20px;
   margin-bottom: 15px;
   align-items: flex-start;
}

.qna-detail-label {
   width: 100px;
   font-weight: bold;
   color: #333;
   flex-shrink: 0;
}

.qna-detail-value {
   flex: 1;
   color: #444;
   word-break: break-all;
   line-height: 1.6;
}

.qna-detail-content {
   min-height: 180px;
   padding: 18px;
   background: #fff;
   border: 1px solid #ddd;
   border-radius: 8px;
   line-height: 1.8;
   white-space: pre-wrap;
}

.qna-comment-box {
   margin-top: 30px;
}

.qna-comment-title {
   font-size: 22px;
   font-weight: bold;
   margin-bottom: 15px;
}

.qna-comment-item {
   border: 1px solid #ddd;
   border-radius: 10px;
   padding: 18px;
   margin-bottom: 15px;
   background: #fff;
}

.qna-comment-top {
   display: flex;
   justify-content: space-between;
   align-items: center;
   margin-bottom: 10px;
}

.qna-comment-writer {
   font-weight: bold;
   color: #333;
}

.qna-comment-date {
   color: #777;
   font-size: 14px;
}

.qna-comment-content {
   line-height: 1.7;
   white-space: pre-wrap;
   color: #444;
}

.qna-detail-btn-wrap {
   display: flex;
   justify-content: flex-end;
   margin-top: 25px;
}

.qna-detail-back {
   display: inline-block;
   padding: 12px 24px;
   background: #6b83d6;
   color: #fff;
   text-decoration: none;
   border-radius: 8px;
   font-weight: bold;
}

.qna-detail-back:hover {
   background: #5670c9;
}

.qna-no-comment {
   padding: 20px;
   border: 1px solid #ddd;
   border-radius: 10px;
   background: #fff;
   color: #666;
}
</style>
</head>

<body class="qna-body">
   <div class="qna-container">

      <header class="qna-top">
         <div class="qna-title">
            <a href="${pageContext.request.contextPath}/admin/main.adfc">관리자 페이지</a>
         </div>

         <nav class="qna-menu">
            <a href="${pageContext.request.contextPath}/admin/memberInfo.adfc">회원 관리</a>
            <a href="${pageContext.request.contextPath}/admin/insertQuestion.adfc">메인 관리</a>
            <a href="${pageContext.request.contextPath}/admin/expoSchedule.adfc">커뮤니티 관리</a>
         </nav>

         <a href="${pageContext.request.contextPath}/admin/logout.adfc"
            class="qna-logout">로그아웃</a>
      </header>

      <main class="qna-main">

         <aside class="qna-leftbar">
            <div class="qna-left-item">
               <a href="${pageContext.request.contextPath}/admin/expoSchedule.adfc">박람회 일정</a>
            </div>
            <div class="qna-left-item">
               <a href="${pageContext.request.contextPath}/admin/communityManagement.adfc">자유 게시판</a>
            </div>
            <div class="qna-left-item qna-active">
               <a href="${pageContext.request.contextPath}/admin/companyQnaManagement.adfc">기업 QnA</a>
            </div>
         </aside>

         <section class="qna-content">

            <div class="qna-detail-wrap">
               <div class="qna-detail-title">기업 QnA 상세</div>

               <div class="qna-detail-box">

                  <div class="qna-detail-row">
                     <div class="qna-detail-label">번호</div>
                     <div class="qna-detail-value">${qnaDetail.postNumber}</div>
                  </div>

                  <div class="qna-detail-row">
                     <div class="qna-detail-label">제목</div>
                     <div class="qna-detail-value">${qnaDetail.postTitle}</div>
                  </div>

                  <div class="qna-detail-row">
                     <div class="qna-detail-label">기업명</div>
                     <div class="qna-detail-value">${qnaDetail.companyName}</div>
                  </div>

                  <div class="qna-detail-row">
                     <div class="qna-detail-label">작성자</div>
                     <div class="qna-detail-value">${qnaDetail.userId}</div>
                  </div>

                  <div class="qna-detail-row">
                     <div class="qna-detail-label">작성일</div>
                     <div class="qna-detail-value">${qnaDetail.postDate}</div>
                  </div>

                  <div class="qna-detail-row">
                     <div class="qna-detail-label">상태</div>
                     <div class="qna-detail-value">${qnaDetail.answerStatus}</div>
                  </div>

                  <div class="qna-detail-row">
                     <div class="qna-detail-label">조회수</div>
                     <div class="qna-detail-value">${qnaDetail.viewCount}</div>
                  </div>

                  <div class="qna-detail-row">
                     <div class="qna-detail-label">내용</div>
                     <div class="qna-detail-value">
                        <div class="qna-detail-content">${qnaDetail.postContent}</div>
                     </div>
                  </div>

               </div>

               <div class="qna-comment-box">
                  <div class="qna-comment-title">답변 댓글</div>

                  <c:choose>
                     <c:when test="${empty commentList}">
                        <div class="qna-no-comment">등록된 댓글이 없습니다.</div>
                     </c:when>

                     <c:otherwise>
                        <c:forEach var="comment" items="${commentList}">
                           <div class="qna-comment-item">
                              <div class="qna-comment-top">
                                 <div class="qna-comment-writer">${comment.memberId}</div>
                                 <div class="qna-comment-date">${comment.commentCreatedDate}</div>
                              </div>
                              <div class="qna-comment-content">${comment.commentContent}</div>
                           </div>
                        </c:forEach>
                     </c:otherwise>
                  </c:choose>
               </div>

               <div class="qna-detail-btn-wrap">
                  <a href="${pageContext.request.contextPath}/admin/companyQnaManagement.adfc"
                     class="qna-detail-back">목록으로</a>
               </div>
            </div>

         </section>
      </main>
   </div>
</body>
</html>