<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>자유게시판 공지사항</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main/community/post-notification.css">
</head>

<body>
	<c:set var="isLoggedIn"
		value="${not empty sessionScope.user or not empty sessionScope.userNumber}" />
	<c:set var="defaultCompanyImg"
		value="${pageContext.request.contextPath}/assets/img/기업이미지_샘플1.jpg" />

	<c:choose>
		<c:when test="${not empty sessionScope.userNumber}">
			<c:choose>
				<c:when test="${sessionScope.userType == '기업회원'}">
					<jsp:include page="/app/main/header/header-login-company.jsp" />
				</c:when>
				<c:otherwise>
					<jsp:include page="/app/main/header/header-login-member.jsp" />
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<jsp:include page="/app/main/header/header-logout.jsp" />
		</c:otherwise>
	</c:choose>
	<main class="cnd-wrap">
		<div class="cnd-top">
			<h2 class="cnd-top-ttl">공지사항</h2>
			<a href="${pageContext.request.contextPath}/post/list.pfc"
				class="cnd-top-mv"> 자유게시판으로 이동하기 </a>
		</div>

		<div class="cnd-pnl">
			<c:choose>
				<c:when test="${not empty notice}">
					<div class="cnd-head">
						<h3 class="cnd-head-ttl" id="cndNoticeTitle">
							<c:out value="${notice.postTitle}" />
						</h3>

						<div class="cnd-head-info">
							<span class="cnd-head-info-it" id="cndNoticeWriter"> 작성자:
								<c:out value="${notice.adminId}" />
							</span> <span class="cnd-head-info-it" id="cndNoticeDate"> | 작성일:
								<c:out value="${notice.postDate}" />
							</span> <span class="cnd-head-info-it" id="cndNoticeViews"> |
								조회수: <c:out value="${notice.viewCount}" />
							</span>
						</div>
					</div>

					<div class="cnd-cont" id="cndNoticeContent">
						<c:out value="${notice.postContent}" />
					</div>
				</c:when>

				<c:otherwise>
					<div class="cnd-cont">존재하지 않는 공지사항입니다.</div>
				</c:otherwise>
			</c:choose>

			<div class="cnd-btm">
				<a href="${pageContext.request.contextPath}/post/list.pfc"
					class="cnd-btn">목록으로</a>
			</div>
		</div>
	</main>

	<script
		src="${pageContext.request.contextPath}/assets/js/main/community/post-notification.js"></script>
	<footer><jsp:include page="/app/main/footer/footer.jsp" /></footer>
</body>
</html>